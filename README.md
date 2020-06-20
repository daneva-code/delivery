# delivery

Requirements:
1. 2 Rest Services, one simulating restaurant and another simulating delivery person
2. When delivery service is started it tells restaurant service its host and port
3. Post api to place an order
4. Get api to get status of the order
5. Post api to update status of the order
6. Post api to assign order to delivery person
7. Get api to get current status of delivery person

Overview:
This is delivery service written as a spring boot project. It handles data about delivery person details and order delivery.
'SampleData' class is provided to manage all data in memory. Data is categorised with two entities namely 'DeliveryPersonDetails' having details of a delivery person and 'OrderDeliveryManagement' having details of order delivery.

Project Structure:
src/main/java/com/deliver--
1. Controller-contains all rest apis specifications
2. Service-service layer contains all logics for the apis
3. Dao-dao layer communicates with database for fetching or updating database
4. Models-contain database entities and other entities
5. Request-contains request entities
6. Response-contains api response entities
7. Commons-contains 'SampleData' 

Solution:
1. (requrement1). This is delivery service written as a spring boot project.
2. (requirement2). Whenever application is started, with @PostConstruct a restaurant service api is called to tell current host and port of the app.  
6. (requirement3). Find api in 'DeliveryController' with Post mapping '/delivery/assign'.
7. (requirement4). Find api in 'DeliveryController' with Get mapping '/delivery/person'.


Notes:
This project is a spring boot project which is designed for production readiness in future but currently maintaining all states in memory while it has already been integrated with mysql database.
This project demonstrates my coding styles and project structures 
Authorisation and security has not been added to apis as it was not in requirements.
