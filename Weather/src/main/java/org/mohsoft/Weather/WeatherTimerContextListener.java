package org.mohsoft.Weather;

import org.mohsoft.WeatherTimer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;


public class WeatherTimerContextListener implements ServletContextListener {
    public WeatherTimerContextListener() {
        // TODO Auto-generated constructor stub
    }
    private WeatherTimer timer;

    //the timer gets started when the applications launches
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        timer = (WeatherTimer) context.getAttribute("timer");
        if (timer == null) {
            timer = new WeatherTimer(4000);
            context.setAttribute("timer", timer);
            timer.start();
        }
    }

    // the timer gets destroyed at the end
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        WeatherTimer timer = (WeatherTimer) context.getAttribute("timer");
        if (timer != null) {  
            timer.stop();    
        }
    }
}
