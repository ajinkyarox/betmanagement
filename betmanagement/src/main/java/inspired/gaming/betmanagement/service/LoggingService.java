package inspired.gaming.betmanagement.service;

import org.springframework.stereotype.Service;

@Service
public interface LoggingService {

	public void log(String messageType, String message, Integer userId);
	
}
