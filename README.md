# BTC_PriceChecker

Introduction:

This Test Automation Framework is created using Java + Selenium Web Driver + TestNG. Which can be used across different web based applications. In this approach, the endeavor is to build a lot of applications independent reusable keyword components so that they can directly used for another web application without spending any extra effort. With this framework in place, whenever we need to automate a web based application, we would not need to start from scratch, but use the application independent keyword components to the extent possible and create application specific components for the specific needs.


This framework is created to run the BTC price for 30 Mins with a gap intervals of 10 Secs to check the price

To change the total runtime of the code 
 Change TOTAL_TASK_RUN_TIME in BTCUtil class file
 
To chanhe the time gap between each interval
 Change TASK_TIME_INTERVAL in BTCUtil class file
