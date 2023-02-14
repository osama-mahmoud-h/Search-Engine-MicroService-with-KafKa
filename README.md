# Search engine
# Search Engine Built with Spring Boot and Kafka

This search engine is a microservice-based system built with Spring Boot and Kafka that allows users to search for posts containing text, video URLs, and image URLs. The search engine saves posts along with information such as likes count, comments count, and author details like username, ID, password, and image URL.

## Functionality

The search engine provides the following functionality:

- **Fuzzy search**: Users can search for posts using fuzzy search, which helps to find relevant posts even if the search query contains errors or typos.
- **Suggestion list**: The search engine also provides a suggestion list of words, which helps users to refine their search and find relevant posts more easily.

## Architecture

The search engine is built using a microservice architecture, which allows for greater scalability and flexibility. The system consists of multiple microservices, including a service responsible for inserting data into Elasticsearch. Kafka is used as a message broker to facilitate communication between microservices.

## Getting Started

To get started with the search engine, follow these steps:

1. Install Elasticsearch and Kafka.
2. Clone the search engine repository.
3. Configure the microservices and start the system.
4. Start searching for posts!

For more detailed instructions, please refer to the documentation in the `docs` folder.

## Contributing

Contributions to the search engine are welcome. Please submit a pull request with any changes or improvements you'd like to make.

## License

The search engine is licensed under the MIT License. See the `LICENSE` file for more information.
