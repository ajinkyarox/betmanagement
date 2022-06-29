package inspired.gaming.betmanagement.other;

public class LogDetails {

	private String messageType;

	private String message;

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LogDetails [messageType=" + messageType + ", message=" + message + ", getMessageType()="
				+ getMessageType() + ", getMessage()=" + getMessage() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
