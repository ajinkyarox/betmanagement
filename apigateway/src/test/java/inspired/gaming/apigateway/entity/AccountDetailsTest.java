package inspired.gaming.apigateway.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class AccountDetailsTest {

	@Test
	public void testgetUid() {

		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setUid(1);
		assertEquals(accountDetails.getUid(), Integer.parseInt("1"));
	}

	@Test
	public void testgetUsername() {

		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setUsername("test");
		assertEquals(accountDetails.getUsername(), "test");
	}

	@Test
	public void testgetPassword() {
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setPassword("test");
		assertEquals(accountDetails.getPassword(), "test");
	}

	@Test
	public void testgetDateOfBirth() {
		AccountDetails accountDetails = new AccountDetails();
		Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		accountDetails.setDateOfBirth(date);
		assertEquals(accountDetails.getDateOfBirth(), new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
	}

	@Test
	public void testgetAccountType() {
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setAccountType("test");
		assertEquals(accountDetails.getAccountType(), "test");
	}

}
