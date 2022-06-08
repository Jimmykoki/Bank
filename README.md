# SWE266 bank

## Overview

In this course project, we're going to develop a bank system that implements specific functionalities allowing users to withdraw and deposit. We have to follow the security principles to construct the system during the building phase. On the other hand, we need to inject vulnerabilities into our system and describe how it works.



## Project Description

This is a web application in Java based on Spring MVC framework. In terms of the front-end, we design the pages with BootStrap framework for UI kit. In the back-end, we applied the combination, Spring MVC and MySQL.



## Building instruction

Before we start building the application, make sure you have deployed Tomcat HTTP web server in your local environment. We recommend the Tomcat 9.0.63, which is a mature and stable version. [Download link](https://tomcat.apache.org/download-90.cgi) . According to your operating system, you could select different packages. e.g macOS, tar.gz is great.

![](https://i.imgur.com/aImGrhl.png)


Now, you have installed Tomcat. In this part, we would use IntelliJ to start our project. The first thing we do is that making sure the web file has been loaded.

> click File >> Project Structure >> Facets >> add web file


![](https://i.imgur.com/3RranLP.png)


![](https://i.imgur.com/hDgogCT.png)

![](https://i.imgur.com/9woGnQ1.png)



And, we need to add new configuration. (make sure the http port 8080 was not occupied)

> click Edit Configurations  >>  add new configutation >> Tomcat server

![](https://i.imgur.com/yQDRpPO.png)


In addition, we have to deploy our project in HTTP server

> click Deployment >> + >> Artifact  >> Apply >> ok


![](https://i.imgur.com/dUnpCEB.png)


And then, we need to run local datbase tool, such as Mysql workbench and Navicat, as database connection, further more, we copy the the contents of BankDatabase.sql in **/src/resources** and execute the sql file in database tool. Now, we have create the databse called bank, and a table called account. To make sure our project have connected with local database tools, we need to check the datebase information whether match with the config file, **jdbc.properties**, located in **/src/resources**.


![](https://i.imgur.com/xP1GGtA.png)



Finally, we can strat the project by runing tomcat server, and now can visit the website url **localhost:8080/bank**

![](https://i.imgur.com/WkAPN4M.png)

