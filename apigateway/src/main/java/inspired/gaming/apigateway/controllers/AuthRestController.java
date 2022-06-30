package inspired.gaming.apigateway.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inspired.gaming.apigateway.models.TokenBody;
import inspired.gaming.apigateway.models.TokenResponseBody;
import inspired.gaming.apigateway.util.JwtUtil;
import netscape.javascript.JSObject;

@RestController
public class AuthRestController {

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/auth/login")
	public ResponseEntity<TokenResponseBody> login(@RequestBody TokenBody tokenObj) {
		TokenResponseBody tokenRespBody = new TokenResponseBody();
		try {
			if (tokenObj.getUsername() != null && !tokenObj.getUsername().trim().equals("")) {
				String token = jwtUtil.generateToken(tokenObj.getUsername());

				if (token != null) {
					tokenRespBody.setToken(token);
				} else {
					tokenRespBody.setResponse("Please provide a valid username");
				}

			} else {
				tokenRespBody.setResponse("Please provide username");
			}

		} catch (Exception e) {
			tokenRespBody.setResponse("Error - " + e.getMessage());
		}

		return new ResponseEntity<TokenResponseBody>(tokenRespBody, HttpStatus.OK);
	}

	@PostMapping("/auth/validate")
	public ResponseEntity<TokenResponseBody> validate(@RequestBody TokenResponseBody tokenObj) {
		TokenResponseBody tokenRespBody = new TokenResponseBody();
		try {
			if (tokenObj.getToken() != null && !tokenObj.getToken().equals("")) {
				boolean tokenStatus = jwtUtil.validateToken(tokenObj.getToken());

				if (tokenStatus) {
					tokenRespBody.setResponse("Token Genuine");
				} else {
					tokenRespBody.setResponse("Token Not Genuine");
				}
				tokenRespBody.setToken(null);
			} else {
				tokenRespBody.setResponse("Please provide token");
			}

		} catch (Exception e) {
			tokenRespBody.setResponse("Error - " + e.getMessage());
		}

		return new ResponseEntity<TokenResponseBody>(tokenRespBody, HttpStatus.OK);
	}

}