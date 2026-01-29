# Microservices Project Documentation

## Project Overview
This project is a robust, scalable, and distributed system built using a Microservices Architecture. It leverages the Spring Boot ecosystem and Spring Cloud components to ensure high availability, fault tolerance, and independent scalability of services.

## Architecture Components

### 1. Infrastructure Services
*   **Config Server:** Centralized configuration management using Spring Cloud Config. It manages environment-specific properties for all services from a single Git repository or local file system.
*   **Service Registry (Eureka):** Acts as a service discovery agent, allowing microservices to find and communicate with each other dynamically without hardcoded URLs.
*   **API Gateway:** The single entry point for the system. It handles request routing, authentication filter, and load balancing using Spring Cloud Gateway.
*   **Zipkin & Sleuth:** Provides distributed tracing to monitor and debug request flows across multiple services.

### 2. Core Business Services
*   **User Service:** Manages user registration, profiles, and authentication.
*   **Product Service:** Handles the product catalog, inventory management, and search functionality.
*   **Order Service:** Manages the lifecycle of an order, including placement, status updates, and history.
*   **Payment Service:** Processes transactions and integrates with third-party payment gateways.
*   **Notification Service:** An asynchronous service that sends emails or SMS alerts upon specific events (e.g., Order Placed).

## Key Features

*   **Centralized Configuration:** Manage all service configurations in one place.
*   **Service Discovery:** Automatic registration and discovery of microservices.
*   **Load Balancing:** Client-side load balancing using Spring Cloud LoadBalancer.
*   **Circuit Breaker:** Fault tolerance implemented with Resilience4j to prevent cascading failures.
*   **Distributed Tracing:** End-to-end observability of requests across the microservice ecosystem.
*   **Security:** Centralized security at the Gateway level using JWT (JSON Web Tokens) and Spring Security.
*   **Event-Driven Communication:** Asynchronous inter-service communication using Message Brokers (RabbitMQ/Kafka).
*   **Database per Service:** Each service maintains its own database to ensure loose coupling and data encapsulation.

## Tech Stack

*   **Language:** Java 17+
*   **Framework:** Spring Boot 3.x, Spring Cloud
*   **Security:** Spring Security, JWT
*   **Databases:** PostgreSQL (Relational), MongoDB (NoSQL), Redis (Caching)
*   **Messaging:** RabbitMQ / Apache Kafka
*   **Build Tool:** Maven / Gradle
*   **Containerization:** Docker & Docker Compose
*   **Monitoring:** Prometheus & Grafana

## Getting Started

### Prerequisites
*   JDK 17 or higher
*   Maven 3.8+
*   Docker Desktop

### Running the Project

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/microservice-project.git
    ```
2.  **Start Infrastructure Services:**
    *   Run the `Config Server` first.
    *   Run the `Eureka Server` and verify it's up at `http://localhost:8761`.
3.  **Start Business Services:**
    *   Run `User-Service`, `Product-Service`, etc.
4.  **Start API Gateway:**
    *   Run the `Gateway-Service` to start routing traffic.

## API Endpoints (via Gateway)

| Service | Endpoint | Description |
| :--- | :--- | :--- |
| Gateway | `http://localhost:8080/` | Base URL |
| User | `/api/users/**` | User management |
| Product | `/api/products/**` | Catalog management |
| Order | `/api/orders/**` | Order processing |

## Future Enhancements
*   Implementation of Kubernetes (K8s) for orchestration.
*   ELK Stack (Elasticsearch, Logstash, Kibana) integration for centralized logging.
*   Implementing a Saga Pattern for distributed transactions.
