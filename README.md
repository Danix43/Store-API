# Store

Store-API is a Spring Boot-based backend application designed for a e-commerce store. It features product and order management. All endpoints require user authentication to protect again malicious intent. It uses a H2 in-memory database to store data, and it comes with preloaded entries.

This repository can be used with [Store-Frontend](https://www.github.com/Danix43/Store-Frontend) to deploy a fully running e-commerce application.

## Overview

This application exposes REST endpoints for:

- managing items/products
- creating and retrieving orders
- registering and authenticating users

It is built with Java 25 and Spring Boot 4 and includes a development profile with an in-memory H2 database for local testing.

## Features Implemented

- User registration and login with JWT authentication
- Product catalog management with create and search operations
- Bulk insertion of items
- Item lookup by ID, name, or SKU
- Order creation and retrieval
- Order search by date and customer email
- Global exception handling for consistent API error responses
- H2 in-memory database configured for development/testing

## Technologies Used

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Spring Security
- JWT Tokens (jjwt)
- H2 Database
- Maven
- ModelMapper
- Lombok

## API Modules

The endpoints are also listed on `/api-docs`, in OpenAPI 3 specification.
Swagger-UI is enabled on the project, and can be reached at `/swagger-ui.html`.
All endpoints require authentification.

### Authentication

Base path: `/api/auth`

- `POST /api/auth/register` - register a new user and return a JWT token
- `POST /api/auth/login` - authenticate an existing user and return a JWT token

### Items

Base path: `/api/items`

- `GET /api/items/all` - retrieve all items _(do not need a JWT Token)_
- `GET /api/items/item?id={id}` - retrieve an item by ID
- `GET /api/items/item?name={name}` - retrieve an item by name
- `POST /api/items/newItem` - create a new item
- `POST /api/items/bulkAddItems` - create multiple items at once

### Orders

Base path: `/api/orders`

- `GET /api/orders/all` - retrieve all orders
- `GET /api/orders?date=yyyy-mm-dd` - retrieve orders by purchase date
- `GET /api/orders/order?email=user@example.com` - retrieve order by email
- `POST /api/orders/newOrder` - create a new order

## Installation

### Prerequisites

- Java 25 or a compatible JDK
- Maven

### Clone the repository

```bash
git clone https://github.com/your-username/Store.git
cd Store
```

### Build the project

```bash
./mvnw clean install
```

On Windows PowerShell:

```powershell
./mvnw.cmd clean install
```

## Run the Application

### Development mode

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
./mvnw.cmd spring-boot:run
```

The default active profile is `dev`, so the application starts with the in-memory H2 database configuration defined in `application-dev.yaml`.

Default database credentials configured in the dev profile:

- username: `user`
- password: `pass`

Application URL:

```text
http://localhost:8080
```

## Configuration

The project uses profile-based configuration:

- `application.yaml` - base configuration - change here the running config
- `application-dev.yaml` - local development settings
- `application-prod.yaml` - production environment settings

## License

This project uses the terms listed on the MIT license.
