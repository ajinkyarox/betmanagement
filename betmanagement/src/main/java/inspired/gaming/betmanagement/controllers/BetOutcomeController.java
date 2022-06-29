package inspired.gaming.betmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.BetOutcomeService;
import inspired.gaming.betmanagement.service.LoggingService;

@RestController
public class BetOutcomeController {

	@Autowired
	private BetOutcomeService betOutcomeService; 
	
	@Autowired
	private LoggingService loggingService;
	
	@PostMapping(path = "/calculateWinnings")
	public ResponseEntity<BaseResponse> calculateWinnings(@RequestParam("eventId") Integer eventId){
		BaseResponse baseResponse = null;
		try {
			baseResponse = betOutcomeService .calculateWinnings(eventId);
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		} catch(Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		
		
		return new ResponseEntity<BaseResponse>(baseResponse,HttpStatus.OK);
	}
	
	@GetMapping(path = "/getWinnings")
	public ResponseEntity<BaseResponse> getWinnings(@RequestParam("eventId") Integer eventId){
		BaseResponse baseResponse = null;
		try {
			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			baseResponse = betOutcomeService .getWinnings(eventId);
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		} catch(Exception e) {
			loggingService.log("ERROR", "Inside Exception"+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		loggingService.log("INFO", "Outside "+new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName(), 0);
		
		return new ResponseEntity<BaseResponse>(baseResponse,HttpStatus.OK);
	}
	
}
