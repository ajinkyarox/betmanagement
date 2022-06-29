package inspired.gaming.loggingapplication.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import inspired.gaming.loggingapplication.models.LogDetails;
import inspired.gaming.loggingapplication.models.LogResponse;

class LoggerControllerTest {

	@Test
	void testSaveLogDetails() {
	LoggerController loggerController = new LoggerController();
	LogDetails logDetails = new LogDetails();
	logDetails.setMessage("test");
	logDetails.setMessageType("INFO");
	LogResponse logResponse = new LogResponse();
	logResponse.setStatus(200);
	logResponse.setMessage("Log Details Saved Successfully.");
	assertEquals(loggerController.saveLogDetails(logDetails), new ResponseEntity<LogResponse>(logResponse, HttpStatus.OK));
	}

	@Test
	void testSaveErrorLogDetails() {
	LoggerController loggerController = new LoggerController();
	LogDetails logDetails = new LogDetails();
	logDetails.setMessage("test");
	logDetails.setMessageType("ERROR");
	LogResponse logResponse = new LogResponse();
	logResponse.setStatus(200);
	logResponse.setMessage("Error Log Details Saved Successfully.");
	assertEquals(loggerController.saveErrorLogDetails(logDetails), new ResponseEntity<LogResponse>(logResponse, HttpStatus.OK));
	}
	
}
