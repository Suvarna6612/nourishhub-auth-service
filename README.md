# 🍔 NourishHub Food Delivery Platform 🚀

NourishHub is a real-time scalable food delivery platform inspired by applications like Zomato, Swiggy, and Uber Eats.
The project is being built using modern Spring Boot microservices architecture with a strong focus on security, scalability, real-time communication, and production-ready backend engineering practices.

This project aims to simulate how real-world food delivery platforms work internally, including authentication, restaurant management, ordering systems, live delivery tracking, notifications, and distributed microservices communication.

---

# 🚧 Project Status

NourishHub is currently under active development.

The Authentication Service module has been successfully completed with secure JWT-based authentication and protected REST APIs.

More microservices and real-time features are currently being developed.

---

# ✅ Completed Features

## 🔐 Authentication Service

* User Registration API
* User Login API
* JWT Token Generation
* JWT Token Validation
* Protected APIs using Spring Security
* BCrypt Password Encryption
* Stateless Authentication

---

## 🗄️ Database & Persistence

* PostgreSQL Integration
* Spring Data JPA & Hibernate
* Automatic Entity Table Creation
* Dockerized PostgreSQL Setup

---

## 🛡️ Security

* Spring Security Configuration
* JWT Authentication Filter
* Secured Protected Endpoints
* Role-based authentication foundation

---

## 🧩 Backend Architecture

* Layered Spring Boot Architecture
* DTO Pattern
* Repository Pattern
* Service Layer Implementation
* REST API Development

---

# 🚀 Upcoming Features

## 🍽️ Restaurant Service

* Restaurant Management
* Menu Management
* Food Item APIs

---

## 🛒 Order Service

* Cart System
* Place Orders
* Order History
* Order Status Management

---

## 📍 Real-Time Delivery Tracking

* Live Rider Location Tracking
* Real-Time Order Updates
* WebSocket Communication
* Customer Delivery Tracking

---

## 🔔 Notification System

* Real-Time Notifications
* Order Alerts
* Delivery Status Updates

---

## 💳 Payment Integration

* Razorpay Integration
* Stripe Integration
* Payment Verification

---

## ☁️ Advanced Backend Features

* API Gateway
* Service Discovery
* Microservices Communication
* RabbitMQ / Kafka Messaging
* Redis Caching
* Global Exception Handling
* Docker Compose Setup
* CI/CD Pipeline
* Cloud Deployment

---

# 🧰 Tech Stack

## Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* JWT Authentication

---

## Database

* PostgreSQL
* Redis (Upcoming)

---

## Real-Time Communication

* WebSockets
* RabbitMQ / Kafka (Upcoming)

---

## DevOps & Deployment

* Docker
* Docker Compose
* GitHub Actions (Upcoming)
* Kubernetes (Upcoming)

---

# 📂 Current Project Structure

```text
src/main/java/com/nourishhub/auth_service

├── config
├── controller
├── dto
├── entity
├── repository
├── security
├── service
└── AuthServiceApplication
```

---

# 🔥 Current APIs

## Register User

```http
POST /auth/register
```

---

## Login User

```http
POST /auth/login
```

---

## Protected Profile API

```http
GET /auth/profile
```

Requires JWT Token Authentication.

---

# 🐳 Docker PostgreSQL Setup

```yaml
services:
  postgres:
    image: postgres:latest
    container_name: nourishhub-postgres

    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: root
      POSTGRES_DB: nourishhub_auth_db

    ports:
      - "5432:5432"
```

---

# 🎯 Project Vision

The goal of NourishHub is to build a production-style enterprise backend system that demonstrates:

* scalable microservices architecture
* secure authentication systems
* distributed backend communication
* real-time tracking systems
* cloud-native deployment practices
* production-ready backend engineering

This project is being continuously improved and expanded with advanced backend concepts and real-world architecture patterns.

---

# 👨‍💻 Author

Built with passion using Spring Boot, Microservices, and Real-Time Backend Engineering 🚀
