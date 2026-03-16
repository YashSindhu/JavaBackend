# Library Management System - API Endpoints

Base URL: `http://localhost:8080`

## User Endpoints

### Get All Users
```
GET /api/users
```

### Add User
```
POST /api/users
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "password123"
}
```

## Book Endpoints

### Get All Books
```
GET /api/books
```

### Add Book
```
POST /api/books
Content-Type: application/json

{
  "title": "Spring Boot Guide",
  "author": "John Smith",
  "isbn": "978-1234567890",
  "available": true
}
```

### Delete Book
```
DELETE /api/books/{id}
```

## Borrow Endpoints

### Borrow a Book
```
POST /api/borrow?userId=1&bookId=1
```

### Return a Book
```
PUT /api/borrow/return/{recordId}
```

### Get User Borrow History
```
GET /api/borrow/user/{userId}
```

### Get Active Borrows for User
```
GET /api/borrow/user/{userId}/active
```

### Get All Borrow Records
```
GET /api/borrow
```

## Testing with cURL

### Add User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"username":"john","email":"john@test.com","password":"pass123"}'
```

### Add Book
```bash
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"title":"Java Basics","author":"Jane Doe","isbn":"123456","available":true}'
```

### Borrow Book
```bash
curl -X POST "http://localhost:8080/api/borrow?userId=1&bookId=1"
```

### Return Book
```bash
curl -X PUT http://localhost:8080/api/borrow/return/1
```

### Get User History
```bash
curl http://localhost:8080/api/borrow/user/1
```

### Get Active Borrows
```bash
curl http://localhost:8080/api/borrow/user/1/active
```
