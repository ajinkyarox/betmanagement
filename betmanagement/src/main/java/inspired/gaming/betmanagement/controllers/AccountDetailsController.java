package inspired.gaming.betmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inspired.gaming.betmanagement.entity.AccountDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.AccountDetailsService;

@RestController
public class AccountDetailsController {

	@Autowired
	AccountDetailsService accountDetailsService;
	
	@PostMapping(path="/saveAccountDetails")
	public ResponseEntity<BaseResponse> saveAccountDetails(@RequestBody AccountDetails accountDetails){
		
		BaseResponse baseResponse = null;
		try {
			baseResponse = accountDetailsService.saveAccountDetails(accountDetails);
			
		}
		catch(Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		
		
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
	
	@PostMapping(path="/getAccountDetails")
	public ResponseEntity<BaseResponse> getAccountDetails(@RequestBody AccountDetails accountDetails) {
		BaseResponse baseResponse = null;
		try {
			baseResponse = accountDetailsService.getAccountDetails(accountDetails);
		} catch(Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
}
