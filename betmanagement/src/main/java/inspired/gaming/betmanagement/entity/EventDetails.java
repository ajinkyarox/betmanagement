package inspired.gaming.betmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "EventDetails")
public class EventDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer eventId;

	@Column(name = "eventname")
	public String eventname;

	@Column(name = "eventdescription")
	public String eventDescription;

	@Column(name = "startDateTime")
	public Date startDateTime;

	@Column(name = "enddatetime")
	public Date endDateTime;

	@Column(name = "totalBetAmount")
	public Integer totalBetAmount;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Integer getTotalBetAmount() {
		return totalBetAmount;
	}

	public void setTotalBetAmount(Integer totalBetAmount) {
		this.totalBetAmount = totalBetAmount;
	}

	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", eventname=" + eventname + ", eventDescription="
				+ eventDescription + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", totalBetAmount=" + totalBetAmount + ", getEventId()=" + getEventId() + ", getEventname()="
				+ getEventname() + ", getEventDescription()=" + getEventDescription() + ", getStartDateTime()="
				+ getStartDateTime() + ", getEndDateTime()=" + getEndDateTime() + ", getTotalBetAmount()="
				+ getTotalBetAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
