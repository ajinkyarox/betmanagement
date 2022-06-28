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

	@Column(name = "statusOfMarket")
	public String status;

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

	@Override
	public String toString() {
		return "MarketDetails [marketId=" + marketId + ", marketname=" + marketname + ", marketdescription="
				+ marketdescription + ", status=" + status + ", getMarketId()=" + getMarketId() + ", getMarketname()="
				+ getMarketname() + ", getMarketdescription()=" + getMarketdescription() + ", getStatus()="
				+ getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
