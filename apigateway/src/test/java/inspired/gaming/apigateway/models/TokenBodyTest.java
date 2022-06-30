package inspired.gaming.apigateway.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenBodyTest {

	@Test
	void testGetUsername() {
		TokenBody tokenBody = new TokenBody();
		tokenBody.setUsername("test");
		assertEquals(tokenBody.getUsername(), "test");
	}

}
