package inspired.gaming.apigateway.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import inspired.gaming.apigateway.models.TokenBody;
import inspired.gaming.apigateway.models.TokenResponseBody;

class AuthRestControllerTest {

	@Test
	void testLogin() {
		AuthRestController authRestController = new AuthRestController();
		TokenBody tokenObj = new TokenBody();
		tokenObj.setUsername("ajinkya");
		TokenResponseBody tokenRespBody = new TokenResponseBody();
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhamlua3lhIiwiaWF0IjoxNjU2NTgyNTE4LCJleHAiOjE2NTY1ODM3MTh9.z4ne_VPoYAakwLEglaF1iUowtQiipATvZhDm0BizgiN1t-hnVqRbd31Z9RESet2FSLnv_v17zZC_F3ZE5tK3ug";

		tokenRespBody.setToken(token);
		assertEquals(authRestController.login(tokenObj),
				new ResponseEntity<TokenResponseBody>(tokenRespBody, HttpStatus.OK));

	}

	@Test
	void testValidate() {
		TokenResponseBody tokenRespBody = new TokenResponseBody();
		tokenRespBody.setToken(
				"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhamlua3lhIiwiaWF0IjoxNjU2NTgyNTE4LCJleHAiOjE2NTY1ODM3MTh9.z4ne_VPoYAakwLEglaF1iUowtQiipATvZhDm0BizgiN1t-hnVqRbd31Z9RESet2FSLnv_v17zZC_F3ZE5tK3ug");
		TokenResponseBody tokenRespBody2 = new TokenResponseBody();
		tokenRespBody2.setResponse("Token Not Genuine");
		tokenRespBody2.setToken(null);
		AuthRestController authRestController = new AuthRestController();

		assertEquals(authRestController.validate(tokenRespBody),
				new ResponseEntity<TokenResponseBody>(tokenRespBody2, HttpStatus.OK));
	}

}
