# Complete Java Course - Object-Oriented Programming - Workshop Spring Boot

###### @Author: MaurosMJ
  
<div style="text-align:center;">
    <img src="https://imgur.com/7Aav4E3.png" alt="Spring Boot Logo" width="100" height="100">
</div>
  
This repository is dedicated to a Spring Boot Java project with the following objectives:

- **Create a Spring Boot Java Project:** Set up and configure a Spring Boot application.
- **Implement Domain Model:** Develop and define the domain model for the application.
- **Structure Logical Layers:** Organize the application into logical layers including resource, service, and repository.
- **Configure Test Database (H2):** Set up an H2 database for testing purposes.
- **Populate the Database:** Preload the database with initial data.
- **CRUD Operations:** Implement Create, Retrieve, Update, and Delete functionalities.
- **Exception Handling:** Implement robust exception handling mechanisms.

## Technologies

<div style="text-align:center;">
    <img src="https://imgur.com/VJ6m5sm.png" alt="Technologies">
</div>

- Java
- Spring Boot
- JPA / Hibernate
- H2 Database

## More Information

**Course Link:** [Udemy Java Complete Course](https://www.udemy.com/course/java-curso-completo)  
**Section 23:** Project: Web Services with Spring Boot and JPA / Hibernate

## Index

- [Architecture](#architecture)
- [Worknotes & Commits](#worknotes--commits)
- [Credits](#credits)

## Architecture

### Domain Model

Core business entities and their relationships:

<div style="text-align:center;">
    <img src="https://imgur.com/juHmOMK.png" alt="Domain Model">
</div>
  
<div style="text-align:center;">
    <img src="https://imgur.com/Wmfl6Dw.png" alt="Domain Model Diagram">
</div>

### Logical Layers

- **Resource Layer:** Handles incoming HTTP requests and responses.
- **Service Layer:** Contains business logic and acts as a bridge between the resource and repository layers.
- **Repository Layer:** Manages data access and persistence.
  
<div style="text-align:center;">
    <img src="https://imgur.com/tNu9ezP.png" alt="Logical Layers">
</div>

## Worknotes & Commits

### Worknote #1 - Created UserEntity and UserResource
Commit hash: [1084d0fed9c3d5aee29cef073376ea6499dd920d](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringboot/commit/1084d0fed9c3d5aee29cef073376ea6499dd920d)  
**Checklist:**
- Basic attributes
- Associations (instantiate collections)
- Constructors
- Getters & Setters (collections: only get)
- `hashCode` & `equals`
- Serializable

### Worknote #2 - Created H2 Database Configuration, Test Profile, and JPA Configuration
Commit hash: [75048fc6d7691f78681f26e843b7ec92c3fe35b1](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringboot/commit/75048fc6d7691f78681f26e843b7ec92c3fe35b1)  
**Checklist:**
- JPA & H2 dependencies
- `application.properties`
- `application-test.properties`
- Entity: JPA mapping

### Worknote #3 - JPA Repository, Dependency Injection, Database Seeding 
Commit hash: [2a9195e231e9a275bde2dce1e27ff6056260ea25](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringboot/commit/2a9195e231e9a275bde2dce1e27ff6056260ea25)  
**Checklist:**
- `UserRepository` extends `JPARepository<User, Long>`
- Configuration class for "test" profile
- `@Autowired` `UserRepository`
- Instantiate objects in memory
- Persist objects 

### Worknote #4 - Order, Instant, ISO 8601 
Commit hash: [96ce5ae0da6311686950549f20c7b4636f6dc27a](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringboot/commit/96ce5ae0da6311686950549f20c7b4636f6dc27a)  
**Checklist:**
- Entity
  - "To many" association, lazy loading, `JsonIgnore`
- Repository
- Seed
- Service
- Resource

### Worknote #5 - OrderItem, Many-to-Many Association with Extra Attributes
Commit hash: [510d3e5fb2a39a0ca0b6963e83a7d481afb96781](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringboot/commit/510d3e5fb2a39a0ca0b6963e83a7d481afb96781)  
**Checklist:**
- `OrderItemPK`
- `OrderItem`
- Order one-to-many association
- Seed 

### Worknote #6 - Exception Handling - `findById`
Commit hash: [1974bafcab59e6ba5f9f2a5b5c457a19468f9961](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringboot/commit/1974bafcab59e6ba5f9f2a5b5c457a19468f9961)  
**Checklist:**
- NEW CLASS: `services.exceptions.ResourceNotFoundException`
- NEW CLASS: `resources.exceptions.StandardError`
- NEW CLASS: `resources.exceptions.ResourceExceptionHandler`
- `UserService` 

### Worknote #7 - Exception Handling - `delete`
Commit hash: [41af8ac85804addf12104c19996f7627669cd159](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringboot/commit/41af8ac85804addf12104c19996f7627669cd159)  
**Checklist:**
- NEW CLASS: `services.exceptions.DatabaseException`
- `ResourceExceptionHandler`
- `UserService`
  - `EmptyResultDataAccessException`
  - `DataIntegrityViolationException` 

### Worknote #8 - Exception Handling - `update`
Commit hash: [725110109e97ce235893286ee0f3e44a7c880973](https://github.com/MaurosMJ/curso-javacompletoWorkshopSpringboot/commit/725110109e97ce235893286ee0f3e44a7c880973)  
**Checklist:**
- `UserService`
  - `EntityNotFoundException` 

## Credits

This repository is maintained by [MaurosMJ](https://github.com/MaurosMJ). The projects are based on the 'Java COMPLETO Programação Orientada a Objetos + Projetos' course.

```yaml
openapi: 3.0.0
info:
  title: Complete Java Course - Object-Oriented Programming - Workshop Springboot API
  description: API for managing users, products, orders, and categories in a Spring Boot application.
  version: 1.0.0
servers:
  - url: /api
paths:
  /users:
    get:
      summary: Get all users
      responses:
        '200':
          description: A list of users
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/User'
    post:
      summary: Create a new user
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/User'
      responses:
        '201':
          description: User created successfully
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/User'
  /users/{id}:
    get:
      summary: Get user by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
          description: User ID
      responses:
        '200':
          description: A single user
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/User'
    put:
      summary: Update user by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
          description: User ID
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/User'
      responses:
        '200':
          description: User updated successfully
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/User'
    delete:
      summary: Delete user by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
          description: User ID
      responses:
        '204':
          description: User deleted successfully
  /products:
    get:
      summary: Get all products
      responses:
        '200':
          description: A list of products
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Product'
  /products/{id}:
    get:
      summary: Get product by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
          description: Product ID
      responses:
        '200':
          description: A single product
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Product'
  /orders:
    get:
      summary: Get all orders
      responses:
        '200':
          description: A list of orders
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Order'
  /orders/{id}:
    get:
      summary: Get order by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
          description: Order ID
      responses:
        '200':
          description: A single order
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Order'
  /categories:
    get:
      summary: Get all categories
      responses:
        '200':
          description: A list of categories
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Category'
  /categories/{id}:
    get:
      summary: Get category by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
          description: Category ID
      responses:
        '200':
          description: A single category
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Category'
components:
  schemas:
    User:
      type: object
      properties:
        id:
          type: integer
        name:
          type: string
        email:
          type: string
        phone:
          type: string
        password:
          type: string
    Product:
      type: object
      properties:
        id:
          type: integer
        name:
          type: string
        description:
          type: string
        price:
          type: number
          format: float
    Order:
      type: object
      properties:
        id:
          type: integer
        moment:
          type: string
          format: date-time
        orderStatus:
          type: string
        client:
          $ref: '#/components/schemas/User'
    Category:
      type: object
      properties:
        id:
          type: integer
        name:
          type: string
