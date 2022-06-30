package inspired.gaming.betmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.AccountDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.repository.AccountDetailsRepository;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	private Logging loggingService;

	@Override
	public BaseResponse saveAccountDetails(AccountDetails accountDetails, String token) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			AccountDetails accountDetailsTemp = accountDetailsRepository.findByUsername(accountDetails.getUsername());
			if (accountDetailsTemp == null) {
				accountDetailsRepository.save(accountDetails);
				baseResponse.setMessage("Account Details Saved");
			} else {
				baseResponse.setMessage("Username already exists");
			}
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
			loggingService.log("INFO", "Outside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
		} catch (Exception e) {
			loggingService.log("ERROR", "Inside Exception" + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return baseResponse;
	}

	@Override
	public BaseResponse getAccountDetails(AccountDetails accountDetails, String token) {
		// TODO Auto-generated method stub

		BaseResponse baseResponse = new BaseResponse();
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			AccountDetails accountDetailsTemp = accountDetailsRepository
					.findByUsernameAndPassword(accountDetails.getUsername(), accountDetails.getPassword());
			if (accountDetailsTemp == null) {
				baseResponse.setMessage("Account does not exist.");
			} else {
				baseResponse.setMessage("Account verification successful");
			}
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
			loggingService.log("INFO", "Outside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
		} catch (Exception e) {
			loggingService.log("ERROR", "Inside Exception" + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return baseResponse;

	}

	@Override
	public AccountDetails fetchAccountDetails(Integer uid, String token) {
		// TODO Auto-generated method stub

		AccountDetails accountDetailsTemp = new AccountDetails();
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			accountDetailsTemp = accountDetailsRepository.findByUid(uid);
			loggingService.log("INFO", "Outside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);

		} catch (Exception e) {
			loggingService.log("ERROR", "Inside Exception" + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			e.printStackTrace();
		}

		return accountDetailsTemp;

	}

}
