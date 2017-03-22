package io.egen.api.repository;

import io.egen.api.entity.Weather;

public interface WeatherRepositoryCustom {

	public float findByProperty(String city, String property);

	public Weather findAverage(String city, int duration);

}
