# Payment Microservice 

API Documentation
Swagger documentation is available at http://localhost:8083/swagger-ui.html.

## Overview

The Payment Microservice handles payment processing for ticket bookings. It interacts with payment gateways to process transactions and ensures that payments are successful before confirming ticket bookings.

## Technologies

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database (In-Memory)**
- **SpringDoc OpenAPI (Swagger)**
- **JUnit 5 (JUnit Jupiter)**
- **Mockito**

## Setup

### Prerequisites

- Java 17
- Maven (for building the project)

### Clone the Repository

```bash
git clone https://github.com/your-repo/payment-microservice.git
cd payment-microservice

Build the Project
bash
mvn clean install

Run the Application

bash
mvn spring-boot:run

The application will start on port 8082 by default.

API Endpoints
Process Payment
URL: /payments
Method: POST
Request Body:
json
{
    "ticketId": 1,
    "amount": 50.00,
    "paymentMethod": "Credit Card"
}
Response:
json
Copy code
{
    "transactionId": "123456789",
    "status": "SUCCESS"
}


Testing
To run unit tests, use:
mvn test

Exception Handling
The microservice uses Spring's @ControllerAdvice for centralized exception handling. Common exceptions are:

PaymentFailedException: If the payment process fails.
InvalidPaymentDataException: If the provided payment data is invalid.
Configuration
Application Properties: Configure application settings in src/main/resources/application.properties.
