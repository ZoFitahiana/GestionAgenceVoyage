# Travel Agency Management Application

## Description

This Spring Boot-based travel agency management application allows you to manage various aspects related to trips, clients, employees, payments, and reservations.

## API Endpoints

The application exposes CRUD endpoints for each entity:

### Clients

- `GET /client`: Retrieve the list of all registered clients.
- `GET /client/{id}`: Get details of a specific client.
- `POST /post-client`: Create a new client.
- `PUT /update-client/{id}`: Update information of a client.
- `PATCH /update-partial-client/{id}`: Partially update a client.
- `DELETE /delete-client/{id}`: Delete a client.

### Employees

- `GET /employer`: Retrieve the list of all registered employees.
- `GET /employer/{id}`: Get details of a specific employee.
- `POST /post-employer`: Create a new employee.
- `PUT /update-employer/{id}`: Update information of an employee.
- `PATCH /update-partial-employer/{id}`: Partially update an employee.
- `DELETE /delete-employer/{id}`: Delete an employee.

### Voyages

- `GET /voyage`: Retrieve the list of all available trips.
- `GET /voyage/{id}`: Get details of a specific trip.
- `POST /post-voyage`: Create a new trip.
- `PUT /update-voyage/{id}`: Update information of a trip.
- `PATCH /update-partial-voyage/{id}`: Partially update a trip.
- `DELETE /delete-voyage/{id}`: Delete a trip.

### Payments

- `GET /payment`: Retrieve the list of all recorded payments.
- `GET /payment/{id}`: Get details of a specific payment.
- `POST /post-payment`: Process a new payment.
- `PUT /update-payment/{id}`: Update information of a payment.
- `PATCH /update-partial-payment/{id}`: Partially update a payment.
- `DELETE /delete-payment/{id}`: Delete a payment.

### Reservations

- `GET /reservation`: Retrieve the list of all recorded reservations.
- `GET /reservation/{id}`: Get details of a specific reservation.
- `POST /post-reservation`: Create a new reservation.
- `PUT /update-reservation/{id}`: Update information of a reservation.
- `PATCH /update-partial-reservation/{id}`: Partially update a reservation.
- `DELETE /delete-reservation/{id}`: Delete a reservation.

## Installation and Execution

1. Clone this repository: `git clone https://github.com/ZoFitahiana/GestionAgenceVoyage`
2. Open the project in your IDE (e.g., Eclipse, IntelliJ IDEA).
3. Configure Spring Boot dependencies.
4. Start the application by running the main class.

## Usage

- Ensure the application is running.
- Use tools like Postman to make requests to the various endpoints.
- Refer to the documentation for each endpoint above for details on data to send and expected responses.

