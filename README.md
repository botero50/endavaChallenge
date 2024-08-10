# endavaChallenge
This is a repository to solve the challenge presented by Endava

## Installing
 - Download the repository
 - Make sure you have testNg
 - Make sure maven download all the libraries

## Running Tests:
 - you can run the testcases by right clicking on the folder src/test/java and selecting run as testNg Test

## Structure of the framework
```
endava/
    ├── src/main/java/
    ├───────api/
    │   	├── ...
    ├───────dto/
    │   	├── ...
    ├───────pages/
    │   	├── ...
    ├───────utils/
    │   	├── ...
    ├── src/test/java/
    ├───────apiTest/
    │   	├── ...
    ├───────e2eTest/
    │   	├── ...
    ├───────uiTest/
    │   	├── ...
    ├── src/test/resources/
    ├───────├── ...

```

## src/main/java/
1. api
  This folder contains all the helper classes for the Api framework
2. dto
  This folder contains all the dtos refering to the data management
3. pages
  This folder contains all the pages of the ui framework
4. utils
  This folder contains all the utils to ensure the framework have enought helpers for the code
  
## src/test/java/
This folder contains all the user provided to be tested
1. apiTest
  this folder contains all the API test cases
2. e2eTest
  this folder contains all the End to End test cases
3. uiTest
  this folder contains all the UI test cases

## src/test/resources/
  This folder contains all the resources of the framework
