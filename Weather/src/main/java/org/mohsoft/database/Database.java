package org.mohsoft.database;

import java.util.HashMap;
import java.util.Map;

import org.mohsoft.model.WeatherData;

import jakarta.inject.Singleton;

@Singleton
public class Database {

	private static Map<String, WeatherData> weatherDATA = new HashMap<>();
	public static Map<String, WeatherData> getWeather() {
		return weatherDATA;
	}
}
