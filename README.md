Weather API

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

http://localhost:8080/Weather/webapi/weather/

You can also request data for a specific city by adding the city name to the URL. For example:

http://localhost:8080/Weather/webapi/weather/london

You can access these 5 cities: london, tokyo, newyork, dubai, paris

Front End Page

The Weather API includes a front end page that displays the weather data for multiple cities. To access the front end page, go to the following URL:

http://localhost:8080/Weather/WeatherPage

The front end page uses AJAX and an observer pattern to automatically update the data for the cities you want to keep track of.
