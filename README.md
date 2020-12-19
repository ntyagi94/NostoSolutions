# NostoSolutions
This is a coding assessment for Nosto Solutions

Description: Create a site backed by a RESTful API which receives it will get three inputs:
A source currency
A target currency
A monetary value
The API must leverage the exchange rates provided at https://exchangeratesapi.io/ and leverage that to return a converted value. So if your input as 30, USD and GBP, you would need to return the calculated result.

## Getting Started
### Prerequisites
* Git
* JDK 8 or later
* Maven 3.0 or later

### Clone
To get started you can simply clone this repository using git or download the project and import using pom.xml file in your IDE.

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the src/main/java/com/nosto/CurrencyConverterApplication.java class from your IDE.
Hit the URL on your web browser http://localhost:9003/


### Configuration
The configuration is located in src/main/resources/application.properties. You can enter the URLs while the application is running on browser or postman app , you will get the expected output. 


### Unit Test 
The JUnit unit tests are located under their respective package:
src/test/java/com/nosto
