## Volodymyr Panasenko
### System specification used for hometask
os.name: 'Windows 10',
os.arch: 'amd64', 
os.version: '10.0', 
java.version: '17.0.2'


### Run project 
* Run from your IDE all project starting from file `src/test/java/TestRunner.java`

To see allure report use command `allure serve target/allure-results`

**NOTE**: for use all of mentioned commands you should be at root directory with project files

### Additional
* Cucumber features are located [here](src/test/resources/features)
* Cucumber step definitions are [here](src/test/java/stepdefs)
* Example Selenium scenario without using Cucumber is [here](src/test/java/TestScenarioHardcoded.java)
* Page object files are located [here](src/main/java)
