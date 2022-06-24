package inspired.gaming.betmanagement.models;

public class BaseResponse {

	private Integer status;

	private String message;

	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
