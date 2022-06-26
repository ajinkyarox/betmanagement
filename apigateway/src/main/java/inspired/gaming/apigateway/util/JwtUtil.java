package inspired.gaming.apigateway.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import inspired.gaming.apigateway.entity.AccountDetails;
import inspired.gaming.apigateway.repository.AccountDetailsRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.token.validity}")
	private long tokenValidity;

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	public Claims getClaims(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}

	public String generateToken(String id) {
		try {
			AccountDetails accountDetails = accountDetailsRepository.findByUsername(id);
			if(accountDetails!=null) {
				Claims claims = Jwts.claims().setSubject(id);
				long nowMillis = System.currentTimeMillis();
				long expMillis = nowMillis + tokenValidity;
				Date exp = new Date(expMillis);
				return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
						.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
			} else {
				return null;
			}
			
		} catch (Exception e) {
			return null;
		}

	}

	public boolean validateToken(final String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}