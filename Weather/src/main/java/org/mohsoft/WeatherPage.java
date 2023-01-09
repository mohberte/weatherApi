package org.mohsoft;

import java.io.IOException;
import java.util.List;

import org.mohsoft.model.WeatherData;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;


public class WeatherPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WeatherPage() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				TemplateEngine templateEngine = (TemplateEngine) getServletContext().getAttribute(
						ThymeleafConfiguration.TEMPLATE_ENGINE_ATTR);
					IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext())
					.buildExchange(request, response);
					
					// Initialization of the client that will fetch the data
					Client client = ClientBuilder.newClient();
					WebTarget baseTarget = client.target("http://localhost:8080/Weather/webapi/weather/");
					List<WeatherData> weatherData = baseTarget.request().get(new GenericType<List<WeatherData>>(){});
					
					WebContext context = new WebContext(webExchange);
					context.setVariable("weatherData", weatherData);
					templateEngine.process("index", context, response.getWriter());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
