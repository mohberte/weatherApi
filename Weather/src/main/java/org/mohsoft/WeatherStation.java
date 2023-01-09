package org.mohsoft;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("webapi")
public class WeatherStation extends Application{
	public static void main() {
		System.out.println("Hello");
	}
}

