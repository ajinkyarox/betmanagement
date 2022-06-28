package inspired.gaming.betmanagement.models;

import java.util.List;

import inspired.gaming.betmanagement.entity.AccountDetails;
import inspired.gaming.betmanagement.entity.EventDetails;
import inspired.gaming.betmanagement.entity.MarketDetails;
import inspired.gaming.betmanagement.entity.StakeDetails;

public class BaseResponse {

	private Integer status;

	private String message;

	private List<EventDetails> listOfEDObjects;

	private List<AccountDetails> listOfADObjects;

	private List<MarketDetails> listOfMDObjects;

	private List<StakeDetails> listOfSDObjects;

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

	public List<EventDetails> getListOfEDObjects() {
		return listOfEDObjects;
	}

	public void setListOfEDObjects(List<EventDetails> listOfEDObjects) {
		this.listOfEDObjects = listOfEDObjects;
	}

	public List<AccountDetails> getListOfADObjects() {
		return listOfADObjects;
	}

	public void setListOfADObjects(List<AccountDetails> listOfADObjects) {
		this.listOfADObjects = listOfADObjects;
	}

	public List<MarketDetails> getListOfMDObjects() {
		return listOfMDObjects;
	}

	public void setListOfMDObjects(List<MarketDetails> listOfMDObjects) {
		this.listOfMDObjects = listOfMDObjects;
	}

	public List<StakeDetails> getListOfSDObjects() {
		return listOfSDObjects;
	}

	public void setListOfSDObjects(List<StakeDetails> listOfSDObjects) {
		this.listOfSDObjects = listOfSDObjects;
	}

	@Override
	public String toString() {
		return "BaseResponse [status=" + status + ", message=" + message + ", listOfEDObjects=" + listOfEDObjects
				+ ", listOfADObjects=" + listOfADObjects + ", listOfMDObjects=" + listOfMDObjects + ", listOfSDObjects="
				+ listOfSDObjects + ", getMessage()=" + getMessage() + ", getStatus()=" + getStatus()
				+ ", getListOfEDObjects()=" + getListOfEDObjects() + ", getListOfADObjects()=" + getListOfADObjects()
				+ ", getListOfMDObjects()=" + getListOfMDObjects() + ", getListOfSDObjects()=" + getListOfSDObjects()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
