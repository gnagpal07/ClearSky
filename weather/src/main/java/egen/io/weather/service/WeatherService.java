package egen.io.weather.service;

import java.util.List;

import egen.io.weather.entity.*;

public interface WeatherService {
	
	public List<String> findAll();
	
	public Weather create(Weather weather);

	public Weather findByCity(String city);
	
	public String findByProperty(String city,String property);
	
	public Weather findAverage(String city,int duration);

}
