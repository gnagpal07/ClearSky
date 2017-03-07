package egen.io.weather.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author Gurpreet
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Weather.findAll", query = "SELECT w.city FROM Weather w order by w.timestamp"),
		@NamedQuery(name = "Weather.findByCity", query = "SELECT w FROM Weather w where w.city=:pCity order by timestamp desc"),
		@NamedQuery(name = "Weather.findByTimestamp", query = "SELECT w FROM Weather w where w.city=:pCity and w.timestamp>=:pTimeStamp") })

/*
 * SELECT * FROM weatherdb.weather where city = "Chicago" order by timestamp
 * desc LIMIT 1 ;
 */
public class Weather implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2815743624463248823L;

	@Id
	private String id;

	private String city;
	private String description;
	private float humidity;
	private float pressure;
	private float temperature;

	@OneToOne
	private Wind wind;

	private String timestamp;

	public Weather() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", description=" + description + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", temperature=" + temperature + ", wind=" + wind + ", timestamp="
				+ timestamp + "]";
	}

}
