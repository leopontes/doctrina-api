package br.com.doctrina.spring;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;

@Configuration
public class MvcWebAppConfig implements WebMvcConfigurer {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		String[] resources = { "messages" };
		messageSource.setBasenames(resources);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper mapper = converter.getObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.enable(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		Hibernate5Module hibernate5Module = new Hibernate5Module();
		hibernate5Module.configure(Feature.USE_TRANSIENT_ANNOTATION, false);
		mapper.registerModule(hibernate5Module);
		return converter;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		WebMvcConfigurer.super.addCorsMappings(registry);
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
	}

}