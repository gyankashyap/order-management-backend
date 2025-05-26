# Grocery Order Management System
A RESTful API service built with Spring Boot that manages an online grocery ordering system, allowing for efficient management of customers, grocery items, and orders.
## Overview
This application provides a robust backend for a grocery ordering system with the following features:
- Customer management with validation
- Grocery item inventory with categorization
- Order processing with customer and item relationships
- Complete CRUD operations for all entities
- Proper error handling and data validation

## Architecture
The application follows a layered architecture pattern:
- **Controllers**: Handle HTTP requests and responses
- **Services**: Implement business logic
- **Repositories**: Interface with the database
- **Models**: Define the data structure

## Entity Relationships
- A can place multiple **Orders** **Customer**
- An contains one or more **Grocery Items** **Order**
- A **Grocery Item** can be part of multiple **Orders**

## API Endpoints
### Customer Management
``` 
POST   /api/customers         - Create a new customer
GET    /api/customers         - Retrieve all customers
GET    /api/customers/{id}    - Retrieve a specific customer
PUT    /api/customers/{id}    - Update a customer
DELETE /api/customers/{id}    - Delete a customer
```
### Grocery Item Management
``` 
POST   /api/grocery-items                  - Add a new grocery item
GET    /api/grocery-items                  - Retrieve all grocery items
GET    /api/grocery-items/{id}             - Retrieve a specific grocery item
GET    /api/grocery-items/category/{name}  - Retrieve items by category
PUT    /api/grocery-items/{id}             - Update a grocery item
DELETE /api/grocery-items/{id}             - Delete a grocery item
```
### Order Management
``` 
POST   /api/orders                    - Create a new order
GET    /api/orders                    - Retrieve all orders
GET    /api/orders/{id}               - Retrieve a specific order
GET    /api/orders/customer/{id}      - Retrieve orders by customer
PUT    /api/orders/{id}               - Update an order
DELETE /api/orders/{id}               - Delete an order
```
## 📋 Sample Requests
### Creating a Customer
``` json
POST /api/customers
{
  "name": "Jane Smith",
  "email": "jane.smith@example.com",
  "address": "123 Main Street, Cityville",
  "phone": "555-123-4567"
}
```
### Adding a Grocery Item
``` json
POST /api/grocery-items
{
  "name": "Organic Bananas",
  "category": "Fruits",
  "price": 1.99,
  "quantity": 100
}
```
### Creating an Order
``` json
POST /api/orders
{
  "customer": {
    "id": 1
  },
  "groceryItems": [
    {"id": 1},
    {"id": 3}
  ],
  "orderDate": "2023-05-18T14:30:00",
  "totalPrice": 15.97
}
```
## Technologies Used
- **Java 17**: Core programming language
- **Spring Boot 3.2.3**: Application framework
- **Spring Data JPA**: Data persistence
- **H2 Database**: In-memory database for development
- **Lombok**: Boilerplate code reduction
- **Bean Validation**: Data validation
- **Maven**: Dependency management and build tool

## Getting Started
### Prerequisites
- JDK 17 or later
- Maven 3.6+

### Running the Application
1. Clone the repository
``` 
   git clone https://github.com/gyankashyap/order-management-backend.git
```
2. Navigate to the project directory
``` 
   cd grocery-order-management
```
3. Build and run the application
``` 
   mvn spring-boot:run
```
4. The API will be available at `http://localhost:8080`
