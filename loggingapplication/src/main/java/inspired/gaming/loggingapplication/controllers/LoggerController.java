package inspired.gaming.loggingapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inspired.gaming.loggingapplication.models.LogDetails;
import inspired.gaming.loggingapplication.models.LogResponse;

@RestController
public class LoggerController {
	private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

	@RequestMapping("/saveLogDetails")
	public ResponseEntity<LogResponse> saveLogDetails(@RequestBody LogDetails logDetails) {
		LogResponse logResponse = new LogResponse();
		logResponse.setStatus(200);
		try {
			logger.info(logDetails.getMessageType() + "->" + logDetails.getMessage());
			logResponse.setMessage("Log Details Saved Successfully.");
		} catch (Exception e) {
			logResponse.setMessage("Error in saving log details-" + e.getMessage());

		}

		return new ResponseEntity<LogResponse>(logResponse, HttpStatus.OK);
	}

	@RequestMapping("/saveErrorLogDetails")
	public ResponseEntity<LogResponse> saveErrorLogDetails(@RequestBody LogDetails logDetails) {
		LogResponse logResponse = new LogResponse();
		logResponse.setStatus(200);
		try {
			logger.error(logDetails.getMessageType() + "->" + logDetails.getMessage());
			logResponse.setMessage("Error Log Details Saved Successfully.");
		} catch (Exception e) {
			logResponse.setMessage("Error in saving log details-" + e.getMessage());

		}

		return new ResponseEntity<LogResponse>(logResponse, HttpStatus.OK);
	}
}
