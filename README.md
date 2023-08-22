Weather API
![weather-front (2)](https://github.com/mohberte/weatherApi/assets/111369661/60a3ce4d-fa03-46da-aa9b-81088af10ac3)

This project is a REST API that provides simulated weather data for different cities.
Getting Started

To get started with the Weather API, you will need to install the project and run it on your server.
Prerequisites

    Maven

Installation

To install the Weather API, clone the repository and run the following command from the root directory of the project:

mvn package

This will build the project and create a WAR file that you can deploy to a server.
Running the Server

To run the server, deploy the WAR file to a Java servlet container such as Tomcat.
API Documentation

To access all the weather data, send a GET request to the following URL:
![weather-all](https://github.com/mohberte/weatherApi/assets/111369661/b628889b-4c8f-4b79-9f48-810d1dd90cd5)

http://localhost:8080/Weather/webapi/weather/

You can also request data for a specific city by adding the city name to the URL. For example:

![blog-profiles](https://github.com/mohberte/weatherApi/assets/111369661/d1804fc7-0c2f-4774-b23f-da14eee5dadb)

http://localhost:8080/Weather/webapi/weather/london

You can access these 5 cities: london, tokyo, newyork, dubai, paris

Front End Page

The Weather API includes a front end page that displays the weather data for multiple cities. To access the front end page, go to the following URL:

http://localhost:8080/Weather/WeatherPage

The front end page uses AJAX and an observer pattern to automatically update the data for the cities you want to keep track of.

![weather-single](https://github.com/mohberte/weatherApi/assets/111369661/90069c5e-c893-4a96-8911-13e24c186156)

