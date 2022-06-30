package inspired.gaming.apigateway.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

class JwtUtilTest {

	@Test
	void testGetClaims() {
		JwtUtil obj = new JwtUtil();
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhamlua3lhIiwiaWF0IjoxNjU2NTgyNTE4LCJleHAiOjE2NTY1ODM3MTh9.z4ne_VPoYAakwLEglaF1iUowtQiipATvZhDm0BizgiN1t-hnVqRbd31Z9RESet2FSLnv_v17zZC_F3ZE5tK3ug";
		Claims claim = obj.getClaims(token);

		assertEquals(claim, Jwts.parser().setSigningKey("inspiredgamingcorp").parseClaimsJws(token).getBody());
	}

	@Test
	void testValidateToken() {
		JwtUtil obj = new JwtUtil();
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhamlua3lhIiwiaWF0IjoxNjU2NTgyNTE4LCJleHAiOjE2NTY1ODM3MTh9.z4ne_VPoYAakwLEglaF1iUowtQiipATvZhDm0BizgiN1t-hnVqRbd31Z9RESet2FSLnv_v17zZC_F3ZE5tK3ug";

		assertEquals(obj.validateToken(token), Jwts.parser().setSigningKey("inspiredgamingcorp").parseClaimsJws(token));
	}

	@Test
	void testGenerateToken() {
		JwtUtil obj = new JwtUtil();

		assertEquals(obj.generateToken("1"), null);
	}

}
