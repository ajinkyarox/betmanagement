package inspired.gaming.betmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="AccountDetails")
public class AccountDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer uid;
	
	@Column(name="username")
	public String username;
	
	@Column(name="passwd")
	public String password;
	
	@Column(name="dob")
	public Date dateOfBirth;
	
	@Column(name="accounttype")
	public String accountType;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "AccountDetails [uid=" + uid + ", username=" + username + ", password=" + password + ", dateOfBirth="
				+ dateOfBirth + ", accountType=" + accountType + ", getUid()=" + getUid() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getAccountType()=" + getAccountType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
