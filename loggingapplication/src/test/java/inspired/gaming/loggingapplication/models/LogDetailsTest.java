package inspired.gaming.loggingapplication.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogDetailsTest {

	@Test
	public void testGetMessageType() {
		LogDetails logDetails = new LogDetails();
		logDetails.setMessageType("test");
		assertEquals(logDetails.getMessageType(), "test");
	}

	@Test
	public void testSetMessageType() {
		LogDetails logDetails = new LogDetails();
		logDetails.setMessageType("test");
		assertEquals(logDetails.getMessageType(), "test");
	}

}
