# retailbill-API
Api for Customer Bill calculation

This is a sample Java / Maven / Spring Boot (version 2.1.5) application that can be used as a starter for creating a rest service.

## How to Run

- Clone this repository
- Make sure you are using JDK 1.8 and Maven 3.x
- You can build the project and run the tests by running the below command :
  - mvn clean package
- Once successfully built, you can run the service by these method:
  - mvn spring-boot:run 
- Once the application runs you should see something like this
```
2019-06-17 08:40:52.839  INFO 15408 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-06-17 08:40:53.062  INFO 15408 --- [           main] c.r.r.RetailWebsiteServiceTest           : Started RetailWebsiteServiceTest in 1.128 seconds (JVM running for 5.16
```
## About the Service

This API is used to provide the final bill amount to be paid after the discount which customer will get depending up on the different category products.Customer details,bill details and item details must be passed as inputs to the API in order to fetch the net payable amount .

Endpoint to call the service :
```
http://localhost:8090/getNetBillAmount
```

## Fetch Net Payable Amount

```
POST /getNetBillAmount
Accept: application/json
Content-Type: application/json

{"user":{"id":"1","username":"Jagdeesh","firstName":"Jagadeesh","lastName":"L","type":"CUSTOMER","joinDate":"2015-06-06"},"bill":{"id":1,"storeName":"WestZone",
"items":[{"price":"100","name":"Orange","type":"GROCERY"},
		{"price":"50","name":"Jeans","type":"CLOTHING"}
]}}

RESPONSE: HTTP 201 (CREATED)
```

## Swagger API Specs

Swagger API documentation specs are auto-generated when the server runs. The specs will be published under the URL http://localhost:8090/swagger-ui.html
