package com.example.demo.mappers;

import com.example.demo.model.Post;
import com.example.demo.payload.request.PostRequestDto;
import com.example.demo.payload.response.PostResponceDto;
import org.springframework.stereotype.Component;

@Component
public interface PostMapper {
    Post mapRequestDtoToPost(PostRequestDto postDto);

    PostResponceDto mapPostToResponseDto(Post post);

    //Post mapResponseDtoToPost(PostResponceDto postResponceDto);
}
