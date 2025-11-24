# Spring Boot E-commerce Backend

This is a REST API for an e-commerce backend built with Java 21 and Spring Boot.

## Requirements

- JDK 21
- Maven

## How to Run

1. Open a terminal in the project root directory.
2. Run the application using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
   (Or `mvn spring-boot:run` if you have Maven installed globally)

The application will start on port 8080.

## API Endpoints

You can test these endpoints using Postman, Insomnia, or `curl`.

### 1. List All Products
**GET** `/api/products`

```bash
curl -X GET http://localhost:8080/api/products
```

### 2. Get Product by ID
**GET** `/api/products/{id}`

```bash
curl -X GET http://localhost:8080/api/products/1
```

### 3. Create a Product
**POST** `/api/products`
**Body:** JSON

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Nuevo Producto",
    "descripcion": "Descripción del nuevo producto",
    "precio": 99.99,
    "stock": 10,
    "categoria": "General",
    "imagenUrl": "http://example.com/image.jpg"
  }'
```

### 4. Update a Product
**PUT** `/api/products/{id}`
**Body:** JSON

```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Producto Actualizado",
    "descripcion": "Descripción actualizada",
    "precio": 120.00,
    "stock": 5,
    "categoria": "Actualizado",
    "imagenUrl": "http://example.com/updated.jpg"
  }'
```

### 5. Delete a Product
**DELETE** `/api/products/{id}`

```bash
curl -X DELETE http://localhost:8080/api/products/1
```

## Database

The application uses an in-memory H2 database. Data is seeded on startup.
You can access the H2 console at `http://localhost:8080/h2-console` (if enabled in properties).
- JDBC URL: `jdbc:h2:mem:ecommerce_db`
- User: `sa`
- Password: `password`
