package inspired.gaming.betmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "MarketDetails")
public class MarketDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer marketId;

	@Column(name = "marketname")
	public String marketname;

	@Column(name = "marketdescription")
	public String marketdescription;

	@Column(name = "winst")
	public String winst;
	
	@Column(name = "eventId")
	public Integer eventId;

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getMarketname() {
		return marketname;
	}

	public void setMarketname(String marketname) {
		this.marketname = marketname;
	}

	public String getMarketdescription() {
		return marketdescription;
	}

	public void setMarketdescription(String marketdescription) {
		this.marketdescription = marketdescription;
	}

	
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getWinst() {
		return winst;
	}

	public void setWinst(String winst) {
		this.winst = winst;
	}

	@Override
	public String toString() {
		return "MarketDetails [marketId=" + marketId + ", marketname=" + marketname + ", marketdescription="
				+ marketdescription + ", winst=" + winst + ", eventId=" + eventId + ", getMarketId()=" + getMarketId()
				+ ", getMarketname()=" + getMarketname() + ", getMarketdescription()=" + getMarketdescription()
				+ ", getEventId()=" + getEventId() + ", getWinst()=" + getWinst() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
