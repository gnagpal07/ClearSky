package egen.io.weather.repository;

import java.util.List;

import egen.io.weather.entity.Weather;

public interface WeatherRepository {
	
	public List<String> findAll();
	
	public Weather create(Weather weather);
	
	public Weather findByCity(String city);
	
	public float findByProperty(String city,String property);
	
	public Weather findAverage(String city,int duration);

}
