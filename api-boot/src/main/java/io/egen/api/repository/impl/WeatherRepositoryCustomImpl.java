package io.egen.api.repository.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.entity.Wind;
import io.egen.api.entity.Weather;
import io.egen.api.repository.WeatherRepositoryCustom;

@Repository
public class WeatherRepositoryCustomImpl implements WeatherRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public float findByProperty(String city, String property) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByCity", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weather = query.getResultList();
		if(!weather.isEmpty()){
			if(property.equals("temperature")){
				return weather.get(0).getTemperature();
			}
			if(property.equals("humidity")){
				return weather.get(0).getHumidity();
			}
			if(property.equals("pressure")){
				return weather.get(0).getPressure();
			}
			else{
				return 0;
			}
		}
		else{
		return 0;
		}
	}

	@Override
	public Weather findAverage(String city, int duration) {
		Timestamp oneHourAgo = new Timestamp(System.currentTimeMillis() - (duration * 60 * 60 * 1000));
		Instant instantoneHourAgo = oneHourAgo.toInstant();
		String instanceOneHourAgo = instantoneHourAgo.toString();
		
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByTimestamp", Weather.class);
		query.setParameter("pCity", city);
		query.setParameter("pTimeStamp", instanceOneHourAgo);
		List<Weather> weather = query.getResultList();
		
		float temperatureTotal = 0;
		float humidityTotal = 0;
		float pressureTotal = 0;
		float windSpeedTotal = 0;
		float windDegreeTotal = 0;
		
		if(!weather.isEmpty()){
		for(int i=0;i<weather.size();i++){
			temperatureTotal += weather.get(i).getTemperature();
			humidityTotal += weather.get(i).getHumidity();
			pressureTotal += weather.get(i).getPressure();
			
			Wind wind = weather.get(i).getWind();
			windSpeedTotal += wind.getSpeed();
			windDegreeTotal += wind.getDegree();
		}

		Weather w = new Weather();
		w.setCity(city);
		w.setHumidity(humidityTotal/weather.size());
		w.setTemperature(temperatureTotal/weather.size());
		w.setPressure(pressureTotal/weather.size());
		Wind w1 = new Wind();
		w1.setDegree(windDegreeTotal/weather.size());
		w1.setSpeed(windSpeedTotal/weather.size());
		w.setWind(w1);
		
		return w;
		}
		else{
		return null;
		}
	}

}
