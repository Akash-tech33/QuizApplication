# 📚 QuizApp - Spring Boot REST API

A Spring Boot-based REST API for creating, managing, and attempting quizzes.  
This project follows a layered architecture with controllers, services, repositories, and models.  
It uses **Spring Boot, JPA, MySQL, and Lombok**.

---

## 🚀 Features

- **Question Management**
  - Add, update, delete, and view questions.
  - Filter questions by category.
  
- **Quiz Management**
  - Create quizzes with a specific category and number of random questions.
  - Retrieve quiz questions without exposing correct answers.
  - Submit quiz answers and get the score.

- **Database Integration**
  - MySQL for data persistence.
  - JPA for ORM mapping.
  
- **Error Handling**
  - Handles missing IDs and invalid requests gracefully.

---

## 🛠️ Tech Stack

- **Backend:** Java 17, Spring Boot 3.5.3  
- **Database:** MySQL  
- **ORM:** Spring Data JPA  
- **Dependencies:** Lombok, Spring Web, Spring Boot Starter Test  

---

## 📂 Project Structure
QuizApp/
├── src/main/java/com/QuizApp/
│ ├── controller/ # REST Controllers
│ ├── model/ # Entity and DTO classes
│ ├── repository/ # JPA Repositories
│ ├── service/ # Business logic
│ └── QuizDemoApplication.java
├── src/main/resources/
│ └── application.properties
├── pom.xml
└── README.md

