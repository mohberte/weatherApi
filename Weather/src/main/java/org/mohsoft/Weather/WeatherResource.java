package org.mohsoft.Weather;

import jakarta.ws.rs.core.MediaType;
import java.util.List;

import org.mohsoft.WeatherTimer;
import org.mohsoft.model.WeatherData;
import org.mohsoft.service.WeatherService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("weather")
public class WeatherResource {
	
	WeatherService weatherService = new WeatherService();
	private static WeatherTimer timer = new WeatherTimer();
	public WeatherResource() {
}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<WeatherData> GetAllData()
	{	
		return weatherService.getAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{city}")
	public WeatherData GetData(@PathParam(value = "city") String city)
	{	
		return weatherService.getCity(city);
	}
	
	
	@GET
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
		public void updateAll(WeatherData weatherData)
		{	
			weatherService.updateWeather();
			
		}
}
