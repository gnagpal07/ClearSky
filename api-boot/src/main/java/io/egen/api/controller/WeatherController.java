package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.constants.Constants;
import io.egen.api.entity.Weather;
import io.egen.api.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://mocker.egen.io")
@RestController
@RequestMapping(value= Constants.WEATHER)
public class WeatherController {
	
	@Autowired
	private WeatherService service;
	
	@RequestMapping(method=RequestMethod.GET,value=Constants.CITY)
	@ApiOperation(value = "Find All Cities", notes = "Returns a list of cities reported in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<String> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "Find latest weather by City", notes = "Returns the latest weather of a city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findOne(@RequestParam(required = false, defaultValue = "") String city) {
		return service.findByCity(city);

	}
	
	@RequestMapping(method=RequestMethod.GET,value=Constants.PROPERTY)
	@ApiOperation(value = "Get weather property", notes = "Returns the latest weather property of a given city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String findByProperty(@RequestParam(required = false, defaultValue = "") String city,String property){
		
		return service.findByProperty(city, property);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value = "Create Weather reading", notes = "Creates a weather reading in the app and stores it in the db")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather create(@RequestBody Weather weather) {
        
		return service.create(weather);
	}
	
	@RequestMapping(method=RequestMethod.GET,value=Constants.DURATION)
	@ApiOperation(value = "Get Average weather reading", notes = "Returns the average weather of a city based on duration in hours")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findAverage(@RequestParam(required = false, defaultValue = "") String city,int duration){
		
		return service.findAverage(city, duration);
	}

}
