# Docker Cloud Demo

## Overview

This project is a simple demonstration of RESTful communication between a Spring Boot backend and an Angular frontend. Both components are containerized separately using Docker and deployed on AWS, showcasing how modern web applications can leverage containerization and cloud services for scalability and ease of deployment.

## Features

- **Containerization**: Both the frontend and backend are built as Docker containers, ensuring consistency across different environments.
- **RESTful API**: The backend exposes a RESTful API for communication with the frontend.
- **Angular Guard**: An Angular guard is implemented to prevent unauthenticated access to the welcome page which calls the backend API. Users must provide a username before they can communicate with the backend.

## Swagger API Documentation

The following links provide access to the Swagger UI for the backend API:

- [API Documentation for this demo project](http://107.22.12.230/swagger-ui.html)

## Test the demo live
- [DemoUi](http://107.22.12.230)

## To Do

- **Add a CI/CD Pipeline**: Implement a continuous integration and continuous deployment pipeline to automate the build, test, and deployment processes.
- **Improve the Project**: Enhance the demo by adding additional features such as:
  - **Security**: Implement authentication and authorization mechanisms.
  - **Data Persistency**: Integrate a database to ensure data persistence across container restarts.

## Getting Started

1. Clone the repository:
   ```bash
   git clone <repository-url>
