package inspired.gaming.betmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.BetOutcomeService;

@RestController
public class BetOutcomeController {

	@Autowired
	private BetOutcomeService betOutcomeService; 
	
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
	
}
