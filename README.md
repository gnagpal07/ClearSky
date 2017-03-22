Egen Weather Project

Swagger URL : http://ec2-35-162-43-215.us-west-2.compute.amazonaws.com/api/swagger-ui.html#/
Jenkins URL : http://ec2-35-162-43-215.us-west-2.compute.amazonaws.com:8090
Rest Module### End Points for Rest Module

No.1# Paste this endpoint in weather sensor on mocker.egen.io to populate the database weatherdb in MySQL RDS Instance
http://ec2-35-162-43-215.us-west-2.compute.amazonaws.com/api/weather

No.2# Get the list of cities that have even reported weather in the past : http://ec2-35-162-43-215.us-west-2.compute.amazonaws.com/api/weather/cities

No.3# Get the lates weather for a given city : http://ec2-35-162-43-215.us-west-2.compute.amazonaws.com/api/weather?city=cityName

No.4# Get the latest weather property for a given city (propertyName = humidity, pressure or temperature) : http://ec2-35-162-43-215.us-west-2.compute.amazonaws.com/api/weather/property?property=propertyName&city=cityName

No.5# Get hourly averaged weather for a city : http://ec2-35-162-43-215.us-west-2.compute.amazonaws.com/api/weather/duration?city=cityName&duration=1

No.6# Get daily averaged for a city :http://ec2-35-162-43-215.us-west-2.compute.amazonaws.com/api/weather/duration?city=cityName&duration=24
