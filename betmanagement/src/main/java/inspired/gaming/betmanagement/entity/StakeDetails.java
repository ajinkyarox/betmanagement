package inspired.gaming.betmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "StakeDetails")
public class StakeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer stakeId;

	@Column(name = "stakeAmount")
	public Integer stakeAmount;

	@JoinColumn(name = "eventId", referencedColumnName = "eventId")
	@Column(name = "eventId")
	public Integer eventId;

	@JoinColumn(name = "marketId", referencedColumnName = "marketId")
	@Column(name = "marketId")
	public Integer marketId;

	@JoinColumn(name = "userId", referencedColumnName = "uid")
	@Column(name = "userId")
	public Integer userId;

	public Integer getStakeId() {
		return stakeId;
	}

	public void setStakeId(Integer stakeId) {
		this.stakeId = stakeId;
	}

	public Integer getStakeAmount() {
		return stakeAmount;
	}

	public void setStakeAmount(Integer stakeAmount) {
		this.stakeAmount = stakeAmount;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "StakeDetails [stakeId=" + stakeId + ", stakeAmount=" + stakeAmount + ", eventId=" + eventId
				+ ", marketId=" + marketId + ", userId=" + userId + ", getStakeId()=" + getStakeId()
				+ ", getStakeAmount()=" + getStakeAmount() + ", getEventId()=" + getEventId() + ", getMarketId()="
				+ getMarketId() + ", getUserId()=" + getUserId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
