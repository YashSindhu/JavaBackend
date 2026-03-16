# Online Book Store — Microservices

A microservices-based online book store built with Spring Boot, Spring Cloud Netflix Eureka, and Spring Cloud Gateway.

## Architecture

```
Postman / Client
      │
      ▼
API Gateway (8080)        ← single entry point
      │
      ├──► book-service (8081)   ← manages books, H2 DB
      │
      └──► order-service (8082)  ← manages orders, H2 DB
                │
                └──► calls book-service via Feign (Eureka discovery)

Eureka Server (8761)      ← service registry for all above
```

## Services

| Service | Port | Description |
|---|---|---|
| eureka-server | 8761 | Service registry — all services register here |
| api-gateway | 8080 | Single entry point — routes requests via Eureka |
| book-service | 8081 | CRUD for books, H2 in-memory DB |
| order-service | 8082 | Place and view orders, calls book-service via Feign |

## Tech Stack

- Java 21
- Spring Boot 3.5.11
- Spring Cloud 2025.0.1
- Spring Cloud Netflix Eureka (service discovery)
- Spring Cloud Gateway (API gateway)
- Spring Cloud OpenFeign (inter-service communication)
- Spring Data JPA
- H2 In-Memory Database

## Prerequisites

- Java 21
- Maven 3.8+
- Eclipse IDE (or any IDE with Maven support)

## Running the Project

> Services must be started in this exact order:

### 1. Eureka Server
```
cd eureka-server
mvn spring-boot:run
```
Visit: http://localhost:8761

### 2. Book Service
```
cd book-service
mvn spring-boot:run
```

### 3. Order Service
```
cd order-service
mvn spring-boot:run
```

### 4. API Gateway
```
cd api-gateway
mvn spring-boot:run
```

Wait for all 4 services to appear as `UP` on the Eureka dashboard before testing.

### Running in Eclipse
- Right-click each project → `Run As` → `Spring Boot App`
- Follow the same startup order above

---

## API Endpoints

All requests go through the **API Gateway on port 8080**.  
Eureka resolves `lb://book-service` and `lb://order-service` to actual instances automatically.

### Book Service

| Method | URL | Description |
|---|---|---|
| GET | `/api/books` | Get all books |
| GET | `/api/books/{id}` | Get book by ID |
| POST | `/api/books` | Create a new book |
| PUT | `/api/books/{id}` | Update a book |
| DELETE | `/api/books/{id}` | Delete a book |

**POST / PUT request body:**
```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884",
  "price": 35.99,
  "quantity": 10,
  "category": "Programming"
}
```

### Order Service

| Method | URL | Description |
|---|---|---|
| POST | `/api/orders` | Place a new order |
| GET | `/api/orders` | Get all orders |

**POST request body:**
```json
{
  "bookId": 1,
  "customerName": "John Doe",
  "quantity": 2
}
```
> `totalPrice`, `status`, and `orderDate` are set automatically by the service.

---

## Microservice Demo Flow

```
1. POST /api/books          → creates a book in book-service DB
2. POST /api/orders         → order-service calls book-service via Feign
                               to fetch price, calculates totalPrice
3. GET  /api/orders         → returns order with auto-calculated totalPrice
```

This proves inter-service communication via Eureka service discovery.

---

## Useful URLs

| URL | Description |
|---|---|
| http://localhost:8761 | Eureka dashboard |
| http://localhost:8761/eureka/apps | All registered services (JSON: add `Accept: application/json` header) |
| http://localhost:8081/h2-console | book-service DB console (JDBC URL: `jdbc:h2:mem:bookdb`) |
| http://localhost:8082/h2-console | order-service DB console (JDBC URL: `jdbc:h2:mem:orderdb`) |

---

## Project Structure

```
Online_book_store/
├── eureka-server/       # Service registry
├── api-gateway/         # Gateway + routing config
├── book-service/        # Book CRUD microservice
└── order-service/       # Order microservice with Feign client
```
