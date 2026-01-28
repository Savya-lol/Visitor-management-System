# Visitor Management System

A Java-based application for managing visitors in an organization with role-based access control.

## Overview

This Visitor Management System enables organizations to efficiently track and manage visitors. It provides different functionality based on user roles (Admin and Receptionist) and features a command-driven interface.

## Features

- **User Authentication:** Secure login system with password hashing.
- **Role-Based Access Control (RBAC):**
  - **Admin Features:**
    - Create, update, and delete receptionists.
    - View list of all receptionists.
    - Clear all visitor logs.
  - **Receptionist Features:**
    - Register new visitors.
    - Check-in and check-out visitors.
    - Display visitor logs.
    - Delete visitor records.

## Technical Architecture

### Design Patterns

- **Command Pattern:** Implements various commands for different user actions.
- **Data Access Object (DAO):** Separates database operations from business logic.
- **Strategy Pattern:** Used for sorting algorithms.

### Technologies Used

- Java 17
- Hibernate ORM for database operations
- SQLite database
- Maven for dependency management

### Database Schema

The system uses three main entities:

- **User:** Stores system users (admin and receptionists)
- **Visitor:** Stores visitor information
- **VisitorLog:** Tracks visitor check-in/check-out activities

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven

### Installation

1. **Clone the repository**
```
git clone https://github.com/Savya-lol/Visitor-management-System.git
```
2. **Navigate to the project directory**
```
cd visitor-management-system
```
3. **Build the project**
```
mvn clean install
```
4. **Create an admin user (if first time setup)**
```
java -cp target/visitor-management-system-1.0-SNAPSHOT.jar com.savya.utilities.setup.AdminCreator
```
5. **Run the application**
```
java -cp target/visitor-management-system-1.0-SNAPSHOT.jar com.savya.Main
```
## Usage

- **Log in with credentials**
  - **Default admin:** 
    - Username: `admin`
    - Password: `password`
- Use the numbered menu to select commands based on your role.

## Project Structure

```com.savya
├── auth             - Authentication services
├── commands         - Command pattern implementation
│   ├── admin        - Admin-specific commands
│   ├── common       - Commands available to all roles
│   └── receptionist - Receptionist-specific commands
├── database         - Database access layer
│   ├── dao          - Data Access Objects
│   └── entities     - Database entities
├── rbac             - Role-based access control
├── security         - Security services
├── services         - Business logic services
└── utilities        - Utility classes
    ├── setup        - Setup utilities
    └── sorting      - Sorting algorithms
```

## Security

The system uses **PBKDF2 with HMAC SHA-256** for secure password storage, including salting and iterations to prevent brute force attacks.
