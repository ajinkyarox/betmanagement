package inspired.gaming.betmanagement.service;

import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.AccountDetails;
import inspired.gaming.betmanagement.models.BaseResponse;

@Service
public interface AccountDetailsService {

	public BaseResponse saveAccountDetails(AccountDetails accountDetails);
	
	public BaseResponse getAccountDetails(AccountDetails accountDetails);
	
	public AccountDetails fetchAccountDetails(Integer uid);
	
}
