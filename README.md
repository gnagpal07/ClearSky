# ClearSky
Egen Weather Project

Rest Module###
End Points for Rest Module

No.1#
Paste this endpoint in weather sensor on mocker.egen.io to populate the database weatherdb in MySQL

No.2# Get the list of cities that have even reported weather in the past
http://localhost:8080/weather/api/weather/cities

No.3# Get the lates weather for a given city
http://localhost:8080/weather/api/weather?city=cityName

No.4# Get the latest weather property for a given city (propertyName = humidity, pressure or temperature)
http://localhost:8080/weather/api/weather/property?property=propertyName&city=cityName

No.5# Get hourly averaged weather for a city
http://localhost:8080/weather/api/weather/duration?city=cityName&duration=1

No.6# Get daily averaged for a city
http://localhost:8080/weather/api/weather/duration?city=cityName&duration=24

