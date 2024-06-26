package br.com.doctrina.spring;

import java.util.TimeZone;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class WebAppInitializer{
	
	private void configurarTimeZone() {
		TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
		TimeZone.setDefault(tz);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onStartup() {
		configurarTimeZone();
	}
}