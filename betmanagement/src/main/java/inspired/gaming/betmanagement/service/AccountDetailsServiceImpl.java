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

	@Override
	public BaseResponse saveAccountDetails(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		try {
			AccountDetails accountDetailsTemp = accountDetailsRepository.findByUsername(accountDetails.getUsername());
			if (accountDetailsTemp == null) {
				accountDetailsRepository.save(accountDetails);
				baseResponse.setMessage("Account Details Saved");
			} else {
				baseResponse.setMessage("Username already exists");
			}
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return baseResponse;
	}

	@Override
	public BaseResponse getAccountDetails(AccountDetails accountDetails) {
		// TODO Auto-generated method stub

		BaseResponse baseResponse = new BaseResponse();
		try {
			AccountDetails accountDetailsTemp = accountDetailsRepository
					.findByUsernameAndPassword(accountDetails.getUsername(), accountDetails.getPassword());
			if (accountDetailsTemp == null) {
				baseResponse.setMessage("Account does not exist.");
			} else {
				baseResponse.setMessage("Account verification successful");
			}
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return baseResponse;

	}

	@Override
	public AccountDetails fetchAccountDetails(Integer uid) {
		// TODO Auto-generated method stub

		AccountDetails accountDetailsTemp  = new AccountDetails();
		try {
			 accountDetailsTemp = accountDetailsRepository
					.findByUid(uid);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return accountDetailsTemp;

	}

}
