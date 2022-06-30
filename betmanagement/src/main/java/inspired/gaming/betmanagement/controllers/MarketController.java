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

import inspired.gaming.betmanagement.entity.MarketDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.Logging;
import inspired.gaming.betmanagement.service.LoggingService;
import inspired.gaming.betmanagement.service.MarketService;

@RestController
public class MarketController {

	@Autowired
	MarketService marketService;

	@Autowired
	private Logging loggingService;
	
	@PostMapping(path = "/saveorUpdateMarketDetails")
	public ResponseEntity<BaseResponse> saveorUpdateMarketDetails(@RequestBody MarketDetails marketDetails,
			@RequestHeader("Authorization") String token) {

		BaseResponse baseResponse = null;

		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse = marketService.saveorUpdateMarketDetails(marketDetails,token);
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

	@GetMapping(path = "/getMarketDetails")
	public ResponseEntity<BaseResponse> getMarketDetails(@RequestParam("marketId") Integer marketId,
			@RequestHeader("Authorization") String token) {
		BaseResponse baseResponse = new BaseResponse();
		List<MarketDetails> listOfMarketDetails = null;
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			listOfMarketDetails = marketService.getMarketDetails(marketId,token);
			baseResponse.setListOfMDObjects(listOfMarketDetails);
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

	@DeleteMapping("/deleteMarketDetails")
	public ResponseEntity<BaseResponse> deleteMarketDetails(@RequestParam("marketId") Integer marketId,
			@RequestHeader("Authorization") String token) {
		BaseResponse baseResponse = null;
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse = marketService.deleteMarketDetails(marketId,token);
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
