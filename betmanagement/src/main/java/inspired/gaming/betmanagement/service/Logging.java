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

@Component
public class Logging{

	@Value("${default.user.id}")
	private Integer defUID;

	@Value("${token.uri}")
	private String tokenUri;

	@Value("${logging.uri}")
	private String loggingUri;

	@Value("${logging.error.uri}")
	private String loggingErrorUri;

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	
	public void log(String messageType, String message, String token) {

		RestTemplate restTemplate = new RestTemplate();
		LogDetails logDetails = new LogDetails();
		try {

			logDetails.setMessageType(messageType);
			logDetails.setMessage(message);
			
			if (token != null) {
				HttpHeaders headers = new HttpHeaders();
				headers.set("Authorization", token);
				HttpEntity<LogDetails> logEntity = new HttpEntity<>(logDetails, headers);
				if (logDetails.getMessageType().equals("INFO")) {
					ResponseEntity<LogResponse> logResponseEntity = restTemplate.postForEntity(loggingUri, logEntity,
							LogResponse.class);

				} else {
					ResponseEntity<LogResponse> logResponseEntity = restTemplate.postForEntity(loggingErrorUri,
							logEntity, LogResponse.class);

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public AccountDetails fetchAccountDetails(Integer uid) {
		// TODO Auto-generated method stub

		AccountDetails accountDetailsTemp = new AccountDetails();
		try {

			accountDetailsTemp = accountDetailsRepository.findByUid(uid);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return accountDetailsTemp;

	}
}
