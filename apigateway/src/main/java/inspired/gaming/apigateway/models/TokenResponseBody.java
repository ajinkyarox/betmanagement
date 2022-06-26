package inspired.gaming.apigateway.models;

public class TokenResponseBody {

	private String token;

	private String response;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenResponseBody [token=" + token + ", response=" + response + ", getToken()=" + getToken()
				+ ", getResponse()=" + getResponse() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
}
