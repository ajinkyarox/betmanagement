package inspired.gaming.betmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name="WinningUsers")
public class WinningUsers {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer wuId;
	
	@JoinColumn(name = "boId", referencedColumnName = "boId")
	@Column(name="boId")
	public Integer boId;
	
	@JoinColumn(name = "userId", referencedColumnName = "uid")
	@Column(name="userId")
	public Integer userId;
	
	@JoinColumn(name = "marketId", referencedColumnName = "marketId")
	@Column(name="marketId")
	public Integer marketId;
	
	@JoinColumn(name = "winningAmount", referencedColumnName = "winningAmount")
	@Column(name="winningAmount")
	public Integer winningAmount;

	public Integer getWuId() {
		return wuId;
	}

	public void setWuId(Integer wuId) {
		this.wuId = wuId;
	}

	public Integer getBoId() {
		return boId;
	}

	public void setBoId(Integer boId) {
		this.boId = boId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public Integer getWinningAmount() {
		return winningAmount;
	}

	public void setWinningAmount(Integer winningAmount) {
		this.winningAmount = winningAmount;
	}

	@Override
	public String toString() {
		return "WinningUsers [wuId=" + wuId + ", boId=" + boId + ", userId=" + userId + ", marketId=" + marketId
				+ ", winningAmount=" + winningAmount + ", getWuId()=" + getWuId() + ", getBoId()=" + getBoId()
				+ ", getUserId()=" + getUserId() + ", getMarketId()=" + getMarketId() + ", getWinningAmount()="
				+ getWinningAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
