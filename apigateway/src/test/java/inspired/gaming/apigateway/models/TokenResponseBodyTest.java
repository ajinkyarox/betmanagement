package inspired.gaming.apigateway.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenResponseBodyTest {

	@Test
	void testGetToken() {
		TokenResponseBody tokenBody = new TokenResponseBody();
		tokenBody.setToken("test");
		assertEquals(tokenBody.getToken(), "test");
	}

	@Test
	void testGetResponse() {
		TokenResponseBody tokenBody = new TokenResponseBody();
		tokenBody.setResponse("test");
		assertEquals(tokenBody.getResponse(), "test");
	}

	
}
