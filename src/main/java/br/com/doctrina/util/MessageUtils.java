package br.com.doctrina.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

	@Autowired
	private MessageSource messageSource;
	
	public MessageUtils(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public String get(String key, Object... params){
		return getMessage(key, params);
	}
	
	public String getMessage(String key, Object... params){
		try {
			return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
		}catch(NoSuchMessageException ex) {
			return null;
		}
	}
	
	public String get(String key){
		try {
			return get(key, new Object[]{});
		}catch(NoSuchMessageException ex) {
			return null;
		}
	}
}
