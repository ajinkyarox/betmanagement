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
import inspired.gaming.betmanagement.service.LoggingService;

@RestController
public class AccountDetailsController {

	@Autowired
	AccountDetailsService accountDetailsService;
	
	@Autowired
	private LoggingService loggingService;
	
	@PostMapping(path="/saveAccountDetails")
	public ResponseEntity<BaseResponse> saveAccountDetails(@RequestBody AccountDetails accountDetails){
		
		BaseResponse baseResponse = null;
		try {
			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			baseResponse = accountDetailsService.saveAccountDetails(accountDetails);
			
		}
		catch(Exception e) {
			loggingService.log("ERROR", "Inside Exception"+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		
		
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
	
	@PostMapping(path="/getAccountDetails")
	public ResponseEntity<BaseResponse> getAccountDetails(@RequestBody AccountDetails accountDetails) {
		BaseResponse baseResponse = null;
		try {
			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			baseResponse = accountDetailsService.getAccountDetails(accountDetails);
			loggingService.log("INFO", "Outside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			
		} catch(Exception e) {
			loggingService.log("ERROR", "Inside Exception"+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
}
