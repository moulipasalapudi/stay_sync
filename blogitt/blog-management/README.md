# Blog Management Application

This is a simple blog management application built with Spring Boot. It allows users to perform CRUD (Create, Read, Update, Delete) operations on blog posts using an in-memory database.

## Features

- Create new blog posts
- Retrieve all blog posts or a specific blog post by ID
- Update existing blog posts
- Delete blog posts

## Technologies Used

- Spring Boot
- Spring Data JPA
- H2 Database (in-memory)
- Maven

## Project Structure

```
blog-management
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── blog
│   │   │               ├── BlogManagementApplication.java
│   │   │               ├── controller
│   │   │               │   └── BlogController.java
│   │   │               ├── model
│   │   │               │   └── BlogPost.java
│   │   │               ├── repository
│   │   │               │   └── BlogRepository.java
│   │   │               └── service
│   │   │                   └── BlogService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── blog
│                       └── BlogManagementApplicationTests.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd blog-management
   ```

2. **Build the project:**
   ```
   mvn clean install
   ```

3. **Run the application:**
   ```
   mvn spring-boot:run
   ```

4. **Access the API:**
   The application will be running on `http://localhost:8080`. You can use tools like Postman or curl to interact with the API.

## API Endpoints

- `POST /api/blogs` - Create a new blog post
- `GET /api/blogs` - Retrieve all blog posts
- `GET /api/blogs/{id}` - Retrieve a blog post by ID
- `PUT /api/blogs/{id}` - Update a blog post by ID
- `DELETE /api/blogs/{id}` - Delete a blog post by ID

## License

This project is licensed under the MIT License.