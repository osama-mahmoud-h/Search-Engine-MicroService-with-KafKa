package com.example.demo.service.implementation;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.Product;
import com.example.demo.payload.ProductDto;
import com.example.demo.service.PostSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostSearchServiceImp implements PostSearchService {
    private static final String POST_INDEX = "postindex";

    private final ElasticsearchOperations elasticsearchOperations;

    public List<Post> processSearch(final String searchWord) {
        log.info("Search with searchWord {}", searchWord);

        // 1. Create query on multiple fields enabling fuzzy search
        QueryBuilder queryBuilder =
                QueryBuilders
                        .multiMatchQuery(searchWord, "text","comments.text","author.username")
                        .fuzziness(Fuzziness.AUTO);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .build();

        // 2. Execute search
        SearchHits<Post> productHits =
                elasticsearchOperations
                        .search(searchQuery, Post.class,
                                IndexCoordinates.of(POST_INDEX));

        // 3. Map searchHits to product list
        List<Post> productMatches = new ArrayList<Post>();
        productHits.forEach(srchHit->{
            productMatches.add(srchHit.getContent());
        });
        return productMatches;
    }

    public List<String> fetchSuggestions(final String searchWord) {
        QueryBuilder queryBuilder = QueryBuilders
                .wildcardQuery("name", searchWord+"*");

        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .withPageable(PageRequest.of(0, 5))
                .build();

        SearchHits<Post> searchSuggestions =
                elasticsearchOperations.search(searchQuery,
                        Post.class,
                        IndexCoordinates.of(POST_INDEX));

        List<String> suggestions = new ArrayList<String>();

        searchSuggestions.getSearchHits().forEach(searchHit->{
            suggestions.add(searchHit.getContent().getText());
        });
        return suggestions;
    }

    public List<IndexedObjectInformation> createPostIndexBulk(final List<Product> products) {

        List<IndexQuery> queries = products.stream()
                .map(product -> new IndexQueryBuilder().withId(product.getId().toString()).withObject(product).build())
                .collect(Collectors.toList());


        return elasticsearchOperations.bulkIndex(queries, IndexCoordinates.of(POST_INDEX));

    }

    public String createPostIndex(Post post) {

        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(post.getId().toString())
                .withObject(post).build();

        String documentId = elasticsearchOperations
                .index(indexQuery, IndexCoordinates.of(POST_INDEX));

        log.info("Index document of post: {}", documentId);
        return documentId;
    }

}
