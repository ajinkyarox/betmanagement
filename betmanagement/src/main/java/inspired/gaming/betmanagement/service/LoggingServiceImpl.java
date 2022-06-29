package inspired.gaming.betmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import inspired.gaming.betmanagement.entity.AccountDetails;
import inspired.gaming.betmanagement.models.TokenBody;
import inspired.gaming.betmanagement.models.TokenResponseBody;
import inspired.gaming.betmanagement.other.LogDetails;
import inspired.gaming.betmanagement.other.LogResponse;
import inspired.gaming.betmanagement.repository.AccountDetailsRepository;

@Service
public class LoggingServiceImpl implements LoggingService{

	@Value("${default.user.id}")
	private Integer defUID;
	
	@Autowired
	AccountDetailsService accountDetailsService;
	
	@Value("${token.uri}")
	private String tokenUri;
	
	@Value("${logging.uri}")
	private String loggingUri;
	
	@Value("${logging.error.uri}")
	private String loggingErrorUri;
	
	@Override
	public void log(String messageType, String message, Integer userId) {
		
		RestTemplate restTemplate = new RestTemplate();
		LogDetails logDetails = new LogDetails();
		TokenBody tokenBody = new TokenBody();
		try {
			logDetails.setMessageType(messageType);
			logDetails.setMessage(message);
			AccountDetails accountDetails = new AccountDetails();
			if(userId!=null && userId!=0) {
				
				accountDetails = accountDetailsService.fetchAccountDetails(userId);
				
			}
			else {
				accountDetails = accountDetailsService.fetchAccountDetails(defUID);

			}
			tokenBody.setUsername(accountDetails.getUsername());
			ResponseEntity<TokenResponseBody> tokenResponseEntity = restTemplate.postForEntity(tokenUri,tokenBody ,TokenResponseBody.class);
			 String token = tokenResponseEntity.getBody().getToken();
			if(token!=null) {
				HttpHeaders headers = new HttpHeaders();
				headers.set("Authorization", token);
				HttpEntity<LogDetails> logEntity = new HttpEntity<>(logDetails, headers);
				if(logDetails.getMessageType().equals("INFO")) {
					ResponseEntity<LogResponse> logResponseEntity = restTemplate.postForEntity(loggingUri, logEntity, LogResponse.class);

				}
				else {
					ResponseEntity<LogResponse> logResponseEntity = restTemplate.postForEntity(loggingErrorUri, logEntity, LogResponse.class);

				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
}
