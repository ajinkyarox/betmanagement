package inspired.gaming.betmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="EventDetails")
public class EventDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer eventId;
	
	@Column(name="eventname")
	public String eventname;
	
	@Column(name="eventdescription")
	public String eventDescription;

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

	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", eventname=" + eventname + ", eventDescription="
				+ eventDescription + ", getEventId()=" + getEventId() + ", getEventname()=" + getEventname()
				+ ", getEventDescription()=" + getEventDescription() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
