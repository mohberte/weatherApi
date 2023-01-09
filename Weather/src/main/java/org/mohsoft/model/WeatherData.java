package org.mohsoft.model;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class WeatherData {
	
		
	private int id;
	private String city;
	private float temperature;
	private float humidity;
	private Date time;
	private String stime;
	
	
	@Override
	public String toString() {
		return "WeatherData [city=" + city + ", temperature=" + temperature + "]";
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public WeatherData(int id, String city, float temperature, float humidity) throws ParseException {
		super();
		this.city = city;
		this.temperature = temperature;
		this.humidity = humidity;
		this.id = id;

		//setting the date with the correct format
		String dt = "2008-01-01";  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));
		
		this.time = c.getTime();
		this.stime = sdf.format(c.getTime());  //this is now the new date	
		
	}

	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public WeatherData()
	{}
	
}
