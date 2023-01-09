package org.mohsoft;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;

public class WeatherTimer extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
private Timer timer;
private long interval;
Client client = ClientBuilder.newClient();

WebTarget baseTarget = client.target("http://localhost:8080/Weather/webapi/weather/update"); // calls  a Rest Get method
Invocation getData = baseTarget
		.request("application/json")
		.buildGet();

public WeatherTimer(long interval) {
    this.interval = interval;
}
public WeatherTimer() {}

public WeatherTimer(HttpServletRequest request, HttpServletResponse response) {
	
	super();
}

public void start() {
    this.timer = new Timer();
    TimerTask task = new TimerTask() {
          @Override
          public void run() {
              getData.invoke();
          }     
    };
    timer.schedule(task, interval, interval);
   
}

public void setInterval(long interval) {
    this.interval = interval;
    stop();
    start();
}

public void stop() {
    timer.cancel();
}

}