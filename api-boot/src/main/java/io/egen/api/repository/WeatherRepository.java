package io.egen.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import io.egen.api.entity.Weather;

public interface WeatherRepository extends Repository<Weather, String> {
	
	@Query("select distinct w.city from Weather w")
	public List<String> findAll();
	
	public Weather save(Weather weather);
	
	public Weather findFirstByCityOrderByTimestampDesc(String city);

}

