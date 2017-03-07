package egen.io.weather.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.io.weather.entity.Weather;
import egen.io.weather.exception.NotFoundException;
import egen.io.weather.repository.WeatherRepository;
import egen.io.weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;

	@Override
	public List<String> findAll() {
		return weatherRepository.findAll();
	}
    
	@Override
	@Transactional
	public Weather create(Weather weather) {
		return weatherRepository.create(weather);
	}

	@Override
	@Transactional
	public Weather findByCity(String city) {
		
		Weather weather = weatherRepository.findByCity(city);
		
		if(weather==null){
			throw new NotFoundException("Weather with city" + city + "does not exist");
		}
		return weather;
	}

	@Override
	@Transactional
	public String findByProperty(String city, String property) {
		
		float propertyValue = weatherRepository.findByProperty(city, property);
		if(propertyValue == 0){
			throw new NotFoundException("Weather with city" + city + "does not exist");
		}
		return property +" is: " + propertyValue;
		
	}

	@Override
	@Transactional
	public Weather findAverage(String city, int duration) {
		Weather weather = weatherRepository.findAverage(city, duration);
		if(weather==null){
			throw new NotFoundException("Weather with city" + city + "does not exist");
		}
		
		return weather;
	}

}
