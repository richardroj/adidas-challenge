**Adidas Challenge**

Solution with microservices architecture with event driven design

**Technologies:**

SpringBoot

Feign to connect between microservices

Kafka to queue

Mongodb to persistence

DDD to Subscription domain in public-service

Junits to test persistence in public-service and test priority logical to select the winner in priority-sale-service

Docker to deploy

Swagger to public API

**Steps to build**

cd /adidas-challenge

mvn clean install

docker-compose build

docker-compose up

Open
Api-gateway url http://localhost:9080/webjars/swagger-ui/index.html

    user: adidas

    password: adidas1234

In Postman use the Collections

    Adidas-challenge.postman_collection.json


**Steps:**

1. The user create a request to suscribe to sale using Rest from public-service

2. The subscription is stored in Mongodb and generated an event in Kafka from priority-sale-service

3. The event is consumed and generated a request to adiclub-service to retrieve information about the user

4. The userData is added into a singletonList to sort and check the user winner.

5. The service connect with email-service using Feign to send an email to user winner

**Notes:**
There is not an optimal solutions because it is posibbe using another technology as to manage the priority selection as to send emails.
