Payment Idempotency API (Afif Khaja, Senior Software Engineer - Java) - 04.18.2016



A minimal, production-oriented Spring Boot REST API demonstrating idempotent payment processing for financial transactions.



\---



Overview



This project implements a backend API that ensures \*\*safe retries and prevents duplicate transactions\*\* using an idempotency key.



In distributed systems (e.g., payment platforms, financial services), clients may retry requests due to timeouts or network failures. Without proper safeguards, this can lead to duplicate processing.



This API solves that problem by enforcing idempotency at both the application and database level.



\---



Key Concept: Idempotency



An operation is idempotent if performing it multiple times produces the same result.



In this project:



\* A unique `idempotencyKey` is provided with each request

\* If the same key is used again:



&#x20; \* The original result is returned

&#x20; \* No duplicate transaction is created



\---



Tech Stack



\* Java 17

\* Spring Boot

\* Spring Data JPA

\* H2 Database (in-memory)

\* Maven



\---



API Endpoint



Create Payment



POST /payments



Request Body



json

{

&#x20; "userId": "user-123",

&#x20; "amount": 250.00,

&#x20; "idempotencyKey": "payment-abc-001"

}



\---



Behavior



| Scenario                               | Result                           |

| -------------------------------------- | -------------------------------- |

| First request with new idempotency key | Payment is created               |

| Repeated request with same key         | Existing payment is returned     |

| Duplicate insertion attempt            | Prevented by database constraint |



\---



How It Works



1\. Application-Level Check



\* The system first queries for an existing payment using the `idempotencyKey`



2\. Database-Level Enforcement



\* A unique constraint is placed on `idempotencyKey`

\* Guarantees no duplicate records even under race conditions



3\. Lookup-Before-Insert Pattern



\* If record exists → return it

\* Else → create new payment



\---



Project Structure



com.afif.paymentapi

├── controller

│   └── PaymentController.java

├── service

│   └── PaymentService.java

├── repository

│   └── PaymentRepository.java

├── entity

│   └── Payment.java

├── dto

│   ├── PaymentRequest.java

│   └── PaymentResponse.java

└── PaymentApiApplication.java



\---



Running the Application



1\. Start the application



bash:

mvn spring-boot:run



2\. Access endpoint



http://localhost:8080/payments



3\. Test with Postman



Send the same request twice and observe:



\* First request → creates payment

\* Second request → returns existing payment (no duplicate)



\---



Example Response



json

{

&#x20; "id": 1,

&#x20; "userId": "user-123",

&#x20; "amount": 250.0,

&#x20; "idempotencyKey": "payment-abc-001",

&#x20; "message": "Payment processed successfully."

}

```



Repeated request:



json

{

&#x20; "id": 1,

&#x20; "userId": "user-123",

&#x20; "amount": 250.0,

&#x20; "idempotencyKey": "payment-abc-001",

&#x20; "message": "Payment already processed. Returning existing record."

}

```



\---



Why This Matters



Idempotency is critical in:



\* Payment systems

\* Financial transactions

\* Distributed systems with retries



This project demonstrates:



\* Backend API design best practices

\* Data integrity enforcement

\* Safe handling of retry scenarios



\---



Future Enhancements



\* Add transaction status (PENDING, SUCCESS, FAILED)

\* Implement retry + failure handling

\* Add integration tests

\* Replace H2 with PostgreSQL

\* Add request validation and error handling

\* Introduce concurrency testing

