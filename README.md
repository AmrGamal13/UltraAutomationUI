# UltraAutomationUI

 ## That Automation Testing is Hybrid framework which Uses 
 1. Selenium
 2. Maven Jaba
 3. DDT using Excel sheet (for storing locators of the webElements) & Proprtis file
 4. using Allure report for generating reports
 5. Using TestNg for assertions
 6. Reading from Properties files for storing environment variables & Test Data
 7. Support all the kind of browsers
_________
## Structure of Project:
### 1- src/main/java

#### Pages Package:
- contains classes for every web page in automation practice app and inside every page , there are list of the elemenets related to that page

#### Utilities Package:
##### Helper:
- Contains all the generic methods in java that are used inside the automation scripts

##### readprop:
- Contains method for reading from properties files

_________
### 2- src/test/java

#### tests Package:
* Contains test classes that are used for executing the test methods inside

#### PurchaseItemsTest Class:
* Test class conntains all the test methods (test cases) with logging of every step , failure , success
* contains one test case  (Purchase Item successfully):
- Verify that the all the seleted items names are added preoprly in the shopping cart
- Verify that the all the seleted items names are added preoprly in the overview cart
- Verify that the success message of purchasing display successfully in the complete page


#### TestBase:
* Contains the base class for defining which env I am testing against, browsers I am testing against and which variable I am calling such as ***Url***
_________
### 3- src/test/resources

#### Excel sheet:
* Contains all the locators of the all elements in every page I use for testing

#### config.properties:
* Contains general env variable like browser name , URL of the app, execution type

#### data.properties:
* Contains some test data I use for testing in the automation practice app
_________
### 4- Listener Package:

* Contains  TestAllureListener to listen to every event of action of the test methods wheter it pass, fail (attaching screenshot) , skip
_________
### 5- Executing & Running Tests

- Navigate to the project path and run the below command line in your terminal
```
$ mvn clean test
```
_________
### 6- Generating reports
- Install Allure report (mac)
```
 $ brew install allure
```

- Generate report:
 * After running the test from the command line, navigate to the path of thr project from your command line
 * Then execute the below command line
 ```
 $ allure serve allure-results
```


* the report will be published and opened in a browser tab as following:


![image](https://user-images.githubusercontent.com/66884373/131124875-e63ba1b3-7e2d-45d6-8074-ace8105b53e9.png)


