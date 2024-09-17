# PaySky Technical Assessment
## 1. Web Automation (Selemium with JUnit)
https://practicesoftwaretesting.com/
Test Case can be found in: src/test/java/basics/PurchaseBasicTests.java

### Notes:
* Run test cases in order as *testProductPayment* needs the creation of users in *testRegisterUser* test case
* Change the emails in the Excel sheet src/test/resources/TestData.xlsx each time you want to run *testRegisterUser* test cases
* Register emails on the Website expire about 30 minutes or less from creation

## 2. API Automation (Rest-Assured)
https://reqres.in/api/users
Test Case can be found in: src/test/java/apiAutomation/RestAssuredRequests.java

## General instructions
1. Clone the repository
2. Open the *pom.xml* file, and rebuild *maven* project to add the dependencies
3. Allure reports were generated, however, the .html file was not

## 3. Bug Reporting
Please, find the Excel sheet with different bug reports for real bugs reported by me in WhatsApp mobile application
1. WhatsApp Chat Back Button after emoji Panel Update: https://docs.google.com/document/d/1NfKuDrgNmuThPUank9X2CPf4YByx1DvzxJsmrdNMqGo
2. WhatsApp Channel followers Count Refresh Issue: https://docs.google.com/document/d/1gb1miPSu4HeBciFmUB3XhllZ5deWFhyY9t_tWApkvYY
