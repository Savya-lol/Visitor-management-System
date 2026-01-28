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
* **Hibernate ORM**
* **SQLite**
* **Maven**

## Database Schema

The system uses three main entities:

* **User**: Stores system users (Admin and Receptionists).
* **Visitor**: Stores visitor details.
* **VisitorLog**: Tracks visitor check-in/check-out activity.

## Getting Started

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
cd Visitor-management-System
```

3. **Build the project**

```bash
mvn clean install
```

4. **Create an admin user (first-time setup only)**

```bash
java -cp target/visitor-management-system-1.0-SNAPSHOT.jar com.savya.utilities.setup.AdminCreator
```

5. **Run the application**

```bash
java -cp target/visitor-management-system-1.0-SNAPSHOT.jar com.savya.Main
```

## Usage

1. **Log in** with your credentials
