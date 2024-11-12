Feature: To validate the google maps api

@Addplace
Scenario Outline: To validate if add place API is working
Given User needs to Add the Add place payload with "<latitude>" "<longitude>" "<accuracy>" "<name>" "<phonenumber>" "<address>" "<types1>" "<types2>" "<website>" "<language>"
When User needs to uset the "addplaceapi" with using "post" http request
Then User needs to check if the status code is 200
And User needs to check if "status" the response body is "OK"
And User needs to check if "scope" the response body is "APP"
And User needs to verify "<name>" using "getplaceapi"

Examples:
|latitude     |longitude    |accuracy  |name       |phonenumber         |address              |types1|types2|website          |language   |
|-34.39489    |-89.38392    |50        |naveenhouse|(+91)3948393894830  |west cross street    |apple |orange|http://google.com|English -IN|

@Deleteplace
Scenario: To validate the delete place functionality
Given User needs to Add the Delete place payload 
When User needs to uset the "deleteplaceapi" with using "post" http request
Then User needs to check if the status code is 200
And User needs to check if "status" the response body is "OK"

