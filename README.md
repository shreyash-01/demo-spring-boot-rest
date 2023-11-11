# REST API using Spring Boot

To Run the Application:

1. Clone this repository.
2. Open in Intellij( recommended ) or Eclipse.
3. Run the project.

**Note** : You must have java and maven installed.

### Endpoints
| HTTP Methods | Use                     | Endpoints                            |
|--------------|-------------------------|--------------------------------------|
| GET          | Get all the users       | http://localhost:8081/users          |
| GET          | Get a particular user   | http://localhost:8081/users/{userID} |
| POST         | Add a new user          | http://localhost:8081/users          |
| PUT          | Update a new user       | http://localhost:8081/users          |
| DELETE       | Delete an existing user | http://localhost:8081/users/{userID} |

##### Note : 
substitite actual user ID in place of {userID}. Ex- [http://localhost:8081/users/1]() 