# Search engine 
Search Engine with Spring Boot and Kafka
This is a search engine built with Spring Boot and Kafka that allows you to search and retrieve data stored in Elasticsearch. This project consists of two microservices - one for inserting data into Elasticsearch, and the other for searching and retrieving data.

Inserting data into Elasticsearch
The microservice responsible for inserting data into Elasticsearch is built with Spring Boot and Kafka. This microservice subscribes to a Kafka topic where it receives messages containing data about posts. Each post contains information such as text, video URL, image URL, likes count, comments count, author information (username, ID, password, image URL), etc.

The microservice parses each message and inserts the data into Elasticsearch. The data is stored in a post index with fields such as text, video URL, image URL, likes count, comments count, author information, etc.

Searching and Retrieving Data
The microservice responsible for searching and retrieving data is also built with Spring Boot and Kafka. This microservice provides fuzzy search capabilities for posts and also provides a suggestion list of words.

To search for posts, the microservice queries Elasticsearch with a search term and retrieves matching posts. The microservice then returns the matching posts to the client.

To provide suggestion lists of words, the microservice uses Elasticsearch's suggest API. The microservice retrieves a list of suggested words based on the search term and returns this list to the client.

Getting Started
To run this project, you will need to have the following installed:

Java 11 or later
Apache Kafka
Elasticsearch
To run the project, follow these steps:

Clone this repository to your local machine.
Start Kafka and Elasticsearch services.
Run the Kafka producer and Elasticsearch indexing microservice with the following command:
ruby
Copy code
$ mvn spring-boot:run -P producer
Run the search and retrieve microservice with the following command:
ruby
Copy code
$ mvn spring-boot:run -P searcher
Use a REST client such as Postman to test the API.
API Endpoints
POST /posts
This endpoint is used to insert a new post into Elasticsearch. The request body should contain the post data in JSON format.

GET /posts/search
This endpoint is used to search for posts in Elasticsearch. The request should contain a "q" parameter with the search term.

GET /posts/suggest
This endpoint is used to get a suggestion list of words based on the search term. The request should contain a "q" parameter with the search term.

Conclusion
This search engine with Spring Boot and Kafka provides a robust and scalable solution for searching and retrieving data stored in Elasticsearch. By using Kafka for message queuing, we ensure that data is processed asynchronously and can be scaled independently. By using Elasticsearch for data storage and retrieval, we provide fast and efficient search capabilities.
