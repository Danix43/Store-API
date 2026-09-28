# Store

Store is a Spring Boot-based backend application designed for managing products and customer orders in a simple e-commerce environment. The project combines inventory management, order processing, and secure user authentication using JWT, making it a solid foundation for a store API or a learning project for enterprise-style Java backend development.

## Overview

This application exposes REST endpoints for:

- managing items/products
- creating and retrieving orders
- registering and authenticating users
- securing protected resources with JWT-based authentication

It is built with Java 25 and Spring Boot 4 and includes a development profile with an in-memory H2 database for local testing.

## Features Implemented

- User registration and login with JWT authentication
- Role-based resource protection for API endpoints
- Product catalog management with create and search operations
- Bulk insertion of items
- Item lookup by ID, name, or SKU
- Order creation and retrieval
- Order search by date and customer email
- Global exception handling for consistent API error responses
- Spring Boot Actuator support for application monitoring
- H2 in-memory database configured for development/testing
- REST API structure ready for extension with frontend integrations

## Tech Stack

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Spring Security
- JWT (jjwt)
- H2 Database
- Maven
- ModelMapper
- Lombok

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/danix43/Store/
│   │       ├── item/
│   │       ├── orders/
│   │       ├── security/
│   │       ├── exception/
│   │       └── StoreApplication.java
│   └── resources/
│       ├── application.yaml
│       ├── application-dev.yaml
│       ├── application-prod.yaml
│       └── data.sql
└── test/
    └── java/
```

## API Modules

### Authentication

Base path: `/api/auth`

- `POST /api/auth/register` - register a new user and return a JWT token
- `POST /api/auth/login` - authenticate an existing user and return a JWT token

### Items

Base path: `/api/items`

- `GET /api/items/all` - retrieve all items
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
- Git

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

Application URL:

```text
http://localhost:8080
```

H2 console:

```text
http://localhost:8080/h2-console
```

Default database credentials configured in the dev profile:

- username: `user`
- password: `pass`

## Configuration

The project uses profile-based configuration:

- `application.yaml` - base configuration
- `application-dev.yaml` - local development settings
- `application-prod.yaml` - production environment settings

The JWT secret and expiration time are defined in the dev configuration.

## Security

The application uses Spring Security with JWT filtering. Public endpoints are intentionally exposed for auth and item listing, while other requests require valid authentication.

## Notes

This project is structured as a backend service and is ideal for learning or extending into a full e-commerce platform with:

- product categories
- order status flows
- payment processing
- admin dashboards
- frontend integration

## License

This project is currently distributed without a specific license declaration.

## Contributing

Contributions, improvements, and bug fixes are welcome. If you want to extend the project, consider adding:

- validation and DTO improvements
- order item details and totals
- pagination and sorting
- more secure password handling strategies
- full CRUD for admin operations
