# Calorie counting program

__Problem area:__ This program could be used in a daily human life for personal health and fitness.

__Project goals:__ To help users calculate their daily nutrition needs based on individual factors and achieve their desire health and fitness goals.

__System responsibilities:__ system will maintain and show to user provided by user information about his daily meals and calculate for him the necessary nutrition needs based on provided parameters. Save food provided by user to general database and use these records to suggest food for other users by their request. Authorize old and register new users.

__System users:__ guest, user.

__Functionalities:__ Get users height, weight, age, gender, (optionally) activity level, desired goal (gain, lose, maintain weight) and period in which it should be done (for gain or lose weight), calculate based on this parameter’s daily nutrition needs and show it to the user. Add user specified food to a database. Show to user food that match parameters (amount of specified nutrients for a 100g, food category) that he writes in search form, sort the received food list by fats/carbohydrates/protein/popularity. Add a food and it amount to user’s daily plan, add nutrients of this food to the daily nutrients plan bars. User can choose food that he dislikes and in this case this food wouldn’t be shown to a user. User can select a day and write time during which he had a training session/ increased physical activity and in this case, program will recalculate nutrient’s goal intake for this day. The program will track users' progress over time, including changes in weight, body composition, and meeting calorie goals. Calculate and show progress charts of gaining/losing weight, nutrients intake, to the user. Allow guests to create an account based on email address, username, and password. Unauthorized users can authorize by writing correct email address and password.

# List of used technologies: 

*	Gradle - for multi-language software development.
* Spring Boot - to build an application. 
*	Spring Boot DevTools – for fast application restart. 
*	Spring Core - provide the fundamental parts of the framework.
*	Spring WEB - to create self-contained HTTP server by using embedded Tomcat. 
*	Spring Data JPA - to easily implement JPA-based repositories. 
*	Spring Security – to implement authentication and secure data storing.
*	Hibernate - to map Java classes to database tables and from Java data types to SQL data types. 
*Liquibase – database to observe changes and work of the application. 
*	Spring MVC - to implement Model-View-Controller pattern. 
*	Thymeleaf – to processing HTML documents and provide data to them. 
*	Validation – to validate incoming attributes. 
*	HTML – to create web page content. 
*	CSS – to add style to web page. 
*	JavaScript – to create dynamic content for web pages.

# User Case diagram
![image](https://github.com/Gentachik/Calorie-counting-program/assets/130185958/5b39921b-159b-487c-9091-16341f372c18)
    
