# Visitor Management System

A Java-based application for managing visitors in an organization, featuring role-based access control (Admin and Receptionist) and a command-driven interface.

## Overview

The Visitor Management System helps organizations track and manage visitors efficiently. Functionality is provided based on the logged-in user’s role:

* **Admin**: Manage receptionist accounts and system-level data.
* **Receptionist**: Register and manage visitor entries and logs.

## Features

### Authentication & Security

* **User authentication** with secure password storage.
* **Password hashing** using **PBKDF2 with HMAC SHA-256**, including unique salts and configurable iterations.

### Role-Based Access Control (RBAC)

#### Admin

* Create, update, and delete receptionist users.
* View all receptionists.
* Clear all visitor logs.

#### Receptionist

* Register new visitors.
* Check-in and check-out visitors.
* View visitor logs.
* Delete visitor records.

## Technical Architecture

### Design Patterns

* **Command Pattern**: Encapsulates user actions as commands.
* **DAO (Data Access Object) Pattern**: Separates persistence logic from business logic.
* **Strategy Pattern**: Used for pluggable sorting algorithms.

### Tech Stack

* **Java 17**
* **Hibernate ORM (6.x)**
* **SQLite**
* **Maven**

## Database Schema

The system uses three main entities:

* **User**: Stores system users (Admin and Receptionists).
* **Visitor**: Stores visitor details.
* **VisitorLog**: Tracks visitor check-in/check-out activity.

## Getting Started

> ⚠️ This project is packaged as a **fat (uber) JAR** using the **Maven Shade Plugin**.
> All dependencies (Hibernate, SQLite, etc.) are bundled.
> **Always run the application using `java -jar`.**

### Prerequisites

* JDK 17 or higher
* Maven

### Installation

1. **Clone the repository**

```bash
git clone https://github.com/Savya-lol/Visitor-management-System.git
```

2. **Navigate to the project directory**

```bash
cd Visitor-management-System/visistor-management-system
```

3. **Build the project**

```bash
mvn clean package
```

4. **Create an admin user (first-time setup only)**

```bash
java -jar visitor-management-system-1.0-SNAPSHOT.jar --init-admin
```

> ⚠️ Run the admin creation step **only once**. Running it multiple times may duplicate or overwrite admin records.

5. **Run the application**

```bash
java -jar visitor-management-system-1.0-SNAPSHOT.jar
```

## Usage

1. **Log in** with your credentials

* Use the admin account created during first-time setup.
* Admins can manage receptionist users.
* Receptionists can manage visitor entries and logs.

## Notes

* The application uses SQLite by default. The database file will be created automatically on first run.
* Hibernate schema generation is handled at startup.

## License

This project is provided for educational purposes.
