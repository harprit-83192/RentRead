# RentRead - Online Book Rental System

RentRead is a RESTful API service built using Spring Boot and MySQL to manage an online book rental system. It provides authentication and authorization features, allowing users to register, login, browse books, rent books, and return books.

## Features

- User Registration and Login: Users can register by providing their email address and password. Passwords are encrypted using BCrypt. Registered users can log in using their email address and password.
- Book Management: Store and manage book details such as title, author, genre, and availability status. Any user can browse all available books, while only administrators can create, update, and delete books.
- Rental Management: Users can rent books, with a limit of two active rentals per user. They can also return books that they have rented.
- Authentication and Authorization: Basic authentication is used with two roles: USER and ADMIN. Private endpoints require authentication, and certain endpoints are restricted to users with specific roles.
- Logging: Logs are used to record information and errors for troubleshooting and monitoring purposes.
- Error Handling: Common errors are handled gracefully, and appropriate HTTP codes are returned.

## Technologies Used

- Spring Boot
- MySQL
- Spring Security
- BCrypt
- Hibernate
- Maven

## Setup

1. Clone the repository.
2. Set up the MySQL database and update the `application.properties` file with the database configuration.
3. Run the application using Maven or your IDE.
4. Access the API endpoints using a tool like Postman.

## API Endpoints

- **POST /api/register**: Register a new user.
- **POST /api/login**: Authenticate and log in a user.
- **GET /api/public/books**: Browse all available books.
- **POST /api/private/books**: Create a new book (admin only).
- **PUT /api/private/books/{bookId}**: Update a book (admin only).
- **DELETE /api/private/books/{bookId}**: Delete a book (admin only).
- **POST /api/private/books/{bookId}/rent**: Rent a book.
- **POST /api/private/books/{bookId}/return**: Return a rented book.


## POSTMAN COLLECTION

{
	"id": "c04d10d3-8e84-4225-8394-c6a5ca4fbc74",
	"name": "RentRead",
	"timestamp": "2024-04-05T12:09:29.484Z",
	"collection_id": "33745963-cc5d1398-e36f-4d5f-b6ce-91d60bf69504",
	"folder_id": 0,
	"environment_id": "0",
	"totalPass": 0,
	"delay": 0,
	"persist": true,
	"status": "finished",
	"startedAt": "2024-04-05T12:09:17.152Z",
	"totalFail": 0,
	"results": [
		{
			"id": "7f6d3823-e74f-4089-aa24-5a9b59c3551d",
			"name": "http://localhost:8080/api/public/register",
			"url": "http://localhost:8080/api/public/register",
			"time": 3362,
			"responseCode": {
				"code": 201,
				"name": "Created"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				3362
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "c0b9e03e-c5f5-42c6-8f4e-84c0f1b60d18",
			"name": "http://localhost:8080/api/public/register",
			"url": "http://localhost:8080/api/public/register",
			"time": 370,
			"responseCode": {
				"code": 201,
				"name": "Created"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				370
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "e57eed19-da8b-45df-b4cc-1ee9eb2a0b25",
			"name": "http://localhost:8080/api/public/register",
			"url": "http://localhost:8080/api/public/register",
			"time": 356,
			"responseCode": {
				"code": 201,
				"name": "Created"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				356
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "7af9b8bc-2add-485c-8f90-ac33f5366d7b",
			"name": "http://localhost:8080/api/private/books",
			"url": "http://localhost:8080/api/private/books",
			"time": 1526,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				1526
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "a152703e-9623-4f7e-bedd-1f65fd8c8d0c",
			"name": "http://localhost:8080/api/private/books",
			"url": "http://localhost:8080/api/private/books",
			"time": 683,
			"responseCode": {
				"code": 403,
				"name": "Forbidden"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				683
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "0ba2d9c8-9c08-46d4-b530-d18612f852de",
			"name": "http://localhost:8080/api/private/books",
			"url": "http://localhost:8080/api/private/books",
			"time": 628,
			"responseCode": {
				"code": 201,
				"name": "Created"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				628
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "f44378a4-3767-437c-a213-678d57f3c14a",
			"name": "http://localhost:8080/api/private/books",
			"url": "http://localhost:8080/api/private/books",
			"time": 542,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				542
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "9b67f1e2-cad6-4ac2-83cd-9008d5aa054c",
			"name": "http://localhost:8080/api/private/books/1/rent",
			"url": "http://localhost:8080/api/private/books/1/rent",
			"time": 606,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				606
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "1e280e05-0665-4b27-a754-6a7115ae4de6",
			"name": "http://localhost:8080/api/private/books/1/rent",
			"url": "http://localhost:8080/api/private/books/1/rent",
			"time": 459,
			"responseCode": {
				"code": 400,
				"name": "Bad Request"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				459
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "494186c0-8e4c-44e4-8ffe-2c6078e74cd4",
			"name": "http://localhost:8080/api/private/books/1/return",
			"url": "http://localhost:8080/api/private/books/1/return",
			"time": 382,
			"responseCode": {
				"code": 400,
				"name": "Bad Request"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				382
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "bac1a639-5947-4c3d-af57-dddf6c9db563",
			"name": "http://localhost:8080/api/private/books/1/return",
			"url": "http://localhost:8080/api/private/books/1/return",
			"time": 427,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				427
			],
			"allTests": [
				{}
			]
		}
	],
	"count": 1,
	"totalTime": 9341,
	"collection": {
		"requests": [
			{
				"id": "7f6d3823-e74f-4089-aa24-5a9b59c3551d",
				"method": "POST"
			},
			{
				"id": "c0b9e03e-c5f5-42c6-8f4e-84c0f1b60d18",
				"method": "POST"
			},
			{
				"id": "e57eed19-da8b-45df-b4cc-1ee9eb2a0b25",
				"method": "POST"
			},
			{
				"id": "7af9b8bc-2add-485c-8f90-ac33f5366d7b",
				"method": "GET"
			},
			{
				"id": "a152703e-9623-4f7e-bedd-1f65fd8c8d0c",
				"method": "POST"
			},
			{
				"id": "0ba2d9c8-9c08-46d4-b530-d18612f852de",
				"method": "POST"
			},
			{
				"id": "f44378a4-3767-437c-a213-678d57f3c14a",
				"method": "GET"
			},
			{
				"id": "9b67f1e2-cad6-4ac2-83cd-9008d5aa054c",
				"method": "POST"
			},
			{
				"id": "1e280e05-0665-4b27-a754-6a7115ae4de6",
				"method": "POST"
			},
			{
				"id": "494186c0-8e4c-44e4-8ffe-2c6078e74cd4",
				"method": "POST"
			},
			{
				"id": "bac1a639-5947-4c3d-af57-dddf6c9db563",
				"method": "POST"
			}
		]
	}
}
