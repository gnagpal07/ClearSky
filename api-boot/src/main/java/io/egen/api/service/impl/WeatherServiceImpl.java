package io.egen.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Weather;
import io.egen.api.exception.NotFoundException;
import io.egen.api.repository.WeatherRepository;
import io.egen.api.repository.WeatherRepositoryCustom;
import io.egen.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@Autowired
	private WeatherRepositoryCustom weatherRepositoryCustom;

	@Override
	public List<String> findAll() {
		return weatherRepository.findAll();
	}
    
	@Override
	@Transactional
	public Weather create(Weather weather) {
		return weatherRepository.save(weather);
	}

	@Override
	@Transactional
	public Weather findByCity(String city) {
		
		Weather weather = weatherRepository.findFirstByCityOrderByTimestampDesc(city);
		
		if(weather==null){
			throw new NotFoundException("Weather with city " + city + " does not exist");
		}
		return weather;
	}

	@Override
	@Transactional
	public String findByProperty(String city, String property) {
		
		float propertyValue = weatherRepositoryCustom.findByProperty(city, property);
		if(propertyValue == 0){
			throw new NotFoundException("Weather with city " + city + " does not exist");
		}
		return property +" is: " + propertyValue;
		
	}

	@Override
	@Transactional
	public Weather findAverage(String city, int duration) {
		Weather weather = weatherRepositoryCustom.findAverage(city, duration);
		if(weather==null){
			throw new NotFoundException("Weather with city " + city + " does not exist");
		}
		
		return weather;
	}

}
