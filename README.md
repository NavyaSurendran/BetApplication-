# BetApplication-
A Betting Application which accepts bets as Json format and creates reports on bets.

Technologies Used:
Spring Boot, JPA, JWT Token, Microservice, Restful Web services, Derby and docker.

Microservice is created to accept 100 bets per second. Bet can accept max connections of 100. This is Configured in application.yml

 created custom validator and used constraint for validation.

Security is done using JWT Token. Upon successful login JwtSecurityTokenGenerator class generates JWT Token which contains userId, date and sign in with HS256 signature algorithm and for every request JWT Token has to be passed in header as Authorization information.

Created  JpaRepository and used @Query and native query for reports.

Created Junit test cases for test coverage using Mockito

Steps for Executing the Application:

Copy the jar into a directory  and execute 
java -jar SportsBet-0.0.1-SNAPSHOT.jar

Sample inputs are available in the sampleinput file


