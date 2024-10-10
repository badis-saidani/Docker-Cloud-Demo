# Docker Cloud Demo

## Overview

This project is a simple demonstration of RESTful communication between a Spring Boot backend and an Angular frontend. Both components are containerized separately using Docker and deployed on AWS, showcasing how modern web applications can leverage containerization and cloud services for scalability and ease of deployment.

## Features

- **Containerization**: Both the frontend and backend are built as Docker containers, ensuring consistency across different environments.
- **RESTful API**: The backend exposes a RESTful API for communication with the frontend.
- **Angular Guard**: An Angular guard is implemented to prevent unauthenticated access to the welcome page which calls the backend API. Users must provide a username before they can communicate with the backend.
- **Interceptor**: In order to add token to the outgoing requests.
- **OAuth2**: Added authorization service (keycloak) for security and account management.

## Swagger API Documentation

The following links provide access to the Swagger UI for the backend API:

- [API Documentation for this demo project](http://107.22.12.230:8080/swagger-ui.html)

## Test the demo live
- [DemoUi](http://107.22.12.230)

http://107.22.12.230


## Getting Started

1. Clone the repository:
   ```bash
   git clone <repository-url>
