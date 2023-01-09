package org.mohsoft.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.mohsoft.database.Database;
import org.mohsoft.model.WeatherData;

public class WeatherService {
	
private static Map<String, WeatherData> weatherData = Database.getWeather();

	public WeatherService() {
	}
	static{
		new Random();
		try {
			weatherData.put("london", new WeatherData(1,"London", 11,68));
			weatherData.put("paris", new WeatherData(2, "Paris", 13,78));
			weatherData.put("newyork", new WeatherData(3, "New York", 16,70));
			weatherData.put("tokyo", new WeatherData(4, "Tokyo", 20,74));
			weatherData.put("dubai", new WeatherData(5, "Dubai", 28,54));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
	public List<WeatherData> getAll() {
		return new ArrayList<WeatherData>(weatherData.values());
	}

	public WeatherData getCity(String city) {
		return weatherData.get(city);
	}


	
	public void updateWeather() {
		
		Random r = new Random();
		int temperature = 0;
		 Set<Map.Entry<String, WeatherData>> entries = weatherData.entrySet();
  	  
		 Calendar c = Calendar.getInstance();
		 
		 Date d = weatherData.get("dubai").getTime();
		 
	  	    c.setTime(d);

	  		c.add(Calendar.DATE, 1);  // number of days to add
	  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  		Date timeTemp = c.getTime();
	  		String stringTimeTemp = sdf.format(timeTemp.getTime());  // dt is now the new date	
	  		
  	  for (Map.Entry<String, WeatherData> entry : entries) {
		
  		  //Getting the keys and values of the Hashmap
  	      String code = entry.getKey();
  	      entry.getValue();
  	      
  	      WeatherData weatherDataTemp = entry.getValue();
  	      
  	      
  	 	  //Incrementing the day    
  	    	    
  	  //setting the temperature depending on the city
  	  if(code.equals("london"))
  		 temperature = 11 + r.nextInt(10);
  	  else if (code.equals("paris"))
  		temperature = 13 + r.nextInt(10);
  	else if (code.equals("newyork"))
  		temperature = 16 + r.nextInt(10);
  	else if (code.equals("tokyo"))
  		temperature = 20 + r.nextInt(10);
  	else if (code.equals("dubai"))
  		temperature = 28 + r.nextInt(10);
  	  
  	weatherDataTemp.setTemperature(temperature);
  	weatherDataTemp.setTime(timeTemp);
  	weatherDataTemp.setStime(stringTimeTemp);
 
  	      
  	      weatherData.put(code, weatherDataTemp);
  	      
	}
   
}
}