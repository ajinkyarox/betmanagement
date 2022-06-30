package inspired.gaming.betmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inspired.gaming.betmanagement.entity.StakeDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.Logging;
import inspired.gaming.betmanagement.service.LoggingService;
import inspired.gaming.betmanagement.service.StakeService;

@RestController
public class StakeController {

	@Autowired
	StakeService stakeService;

	@Autowired
	private Logging loggingService;
	
	@PostMapping(path = "/saveorUpdateStakeDetails")
	public ResponseEntity<BaseResponse> saveorUpdateMarketDetails(@RequestBody StakeDetails stakeDetails,
			@RequestHeader("Authorization") String token) {

		BaseResponse baseResponse = null;

		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse = stakeService.saveorUpdateStakeDetails(stakeDetails,token);
			loggingService.log("INFO", "Outside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			
		} catch (Exception e) {
			loggingService.log("ERROR", "Inside Exception" + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/getStakeDetails")
	public ResponseEntity<BaseResponse> getMarketDetails(@RequestParam("stakeId") Integer stakeId,
			@RequestHeader("Authorization") String token) {
		BaseResponse baseResponse = new BaseResponse();
		List<StakeDetails> listOfStakeDetails = null;
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			listOfStakeDetails = stakeService.getStakeDetails(stakeId,token);
			baseResponse.setListOfSDObjects(listOfStakeDetails);
			loggingService.log("INFO", "Outside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			
		} catch (Exception e) {
			loggingService.log("ERROR", "Inside Exception" + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@DeleteMapping("/deleteStakeDetails")
	public ResponseEntity<BaseResponse> deleteStakeDetails(@RequestParam("stakeId") Integer stakeId,
			@RequestHeader("Authorization") String token) {
		BaseResponse baseResponse = null;
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse = stakeService.deleteStakeDetails(stakeId,token);
			loggingService.log("INFO", "Outside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			
		} catch (Exception e) {
			loggingService.log("ERROR", "Inside Exception" + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);

	}

}
