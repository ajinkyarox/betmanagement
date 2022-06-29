package inspired.gaming.loggingapplication.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogResponseTest {

	@Test
	void testGetStatus() {LogResponse logResponse = new LogResponse();
	logResponse.setStatus(200);
	assertEquals(logResponse.getStatus(), 200);}

	@Test
	void testSetStatus() {
		LogResponse logResponse = new LogResponse();
		logResponse.setStatus(200);
		assertEquals(logResponse.getStatus(), 200);
	}

	@Test
	void testGetMessage() {
		LogResponse logResponse = new LogResponse();
		logResponse.setMessage("Test");
		assertEquals(logResponse.getMessage(), "Test");
	}

	@Test
	void testSetMessage() {
		LogResponse logResponse = new LogResponse();
		logResponse.setMessage("Test");
		assertEquals(logResponse.getMessage(), "Test");
	}



}
