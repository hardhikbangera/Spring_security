# Spring Boot Security with Database Authentication

This project demonstrates a secure Spring Boot web application using Spring Security with user credentials stored in a PostgreSQL database.

## Features

- User authentication backed by a PostgreSQL database.
- Passwords stored securely with BCrypt hashing (strength 12).
- Supports HTTP Basic and form-based authentication.
- Stateless session management for RESTful API design.
- Cross-Site Request Forgery (CSRF) protection disabled for API simplicity.
- Custom `UserDetailsService` loads users from the database.
- Allows open access to specific endpoints (`/student`, `/save`) while securing others.

## Setup Instructions

1. Configure PostgreSQL and create the `User` table with `id`, `username`, and `password`.
2. Insert users with BCrypt-encrypted passwords.
3. Update database connection properties in `application.properties`.
4. Run the Spring Boot application.
5. Access secured endpoints using HTTP Basic or form login with valid credentials.

## Important Notes

- The project uses encoded passwords; passwords must be hashed using BCrypt prior to storing in the DB.
- All endpoints except the permitted ones require authentication.
- This configuration is optimized for stateless REST API security and may require adjustments for session-based or stateful applications.

## Technologies

- Spring Boot
- Spring Security
- PostgreSQL
- Hibernate / JPA
- BCrypt Password Encoder

---

This project provides a strong foundation for implementing secure database-backed authentication in Spring Boot applications.
