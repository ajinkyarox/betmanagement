package inspired.gaming.betmanagement.other;

public class LogResponse {

	private Integer status;

	private String message;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LogResponse [status=" + status + ", message=" + message + ", getStatus()=" + getStatus()
				+ ", getMessage()=" + getMessage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
