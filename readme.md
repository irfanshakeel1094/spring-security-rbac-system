# Spring Security RBAC System

A Role-Based Access Control (RBAC) system built using Spring Boot, Spring Security, and PostgreSQL.

## Features

- User Authentication
- Role-Based Authorization
- Admin and User Roles
- Database Authentication
- Spring Security Integration
- User Creation by Admin
- User Profile Access
- PostgreSQL Database Integration

## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven

## Project Structure

src
├── Config
├── Controller
├── Model
├── Repository
├── Service

## Authentication Flow

Admin Login
↓
Create User
↓
User Login
↓
Access User Details

## API Endpoints

| Method | Endpoint | Access |
|----------|----------|----------|
| POST | /admin/create | ADMIN |
| GET | /user/details | USER |

## Database Setup

1. Create a PostgreSQL database:

```sql
CREATE DATABASE springpractise;
```
2. Execute the database.sql script.
3. Run the Spring Boot application.



The SQL above is written for **PostgreSQL**. 

## Future Improvements

- JWT Authentication
- BCrypt Password Encryption
- Refresh Tokens
- Multiple Roles per User
- Audit Logging

## What I Learned

- Spring Security
- Authentication vs Authorization
- UserDetailsService
- UserPrincipal
- AuthenticationProvider
- Role Based Access Control
- PostgreSQL Integration
- REST API Security
- Debugging 401, 403, 400 and 500 errors

## Author

Shakeel Irfan A R
