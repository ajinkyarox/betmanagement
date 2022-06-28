package inspired.gaming.betmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inspired.gaming.betmanagement.entity.MarketDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.MarketService;

@RestController
public class MarketController {

	@Autowired
	MarketService marketService;

	@PostMapping(path = "/saveorUpdateMarketDetails")
	public ResponseEntity<BaseResponse> saveorUpdateMarketDetails(@RequestBody MarketDetails marketDetails) {

		BaseResponse baseResponse = null;

		try {
			baseResponse = marketService.saveorUpdateMarketDetails(marketDetails);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/getMarketDetails")
	public ResponseEntity<BaseResponse> getMarketDetails(@RequestParam("marketId") Integer marketId) {
		BaseResponse baseResponse = new BaseResponse();
		List<MarketDetails> listOfMarketDetails = null;
		try {
			listOfMarketDetails = marketService.getMarketDetails(marketId);
			baseResponse.setListOfMDObjects(listOfMarketDetails);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@DeleteMapping("/deleteMarketDetails")
	public ResponseEntity<BaseResponse> deleteMarketDetails(@RequestParam("marketId") Integer marketId) {
		BaseResponse baseResponse = null;
		try {
			baseResponse = marketService.deleteEventDetails(marketId);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);

	}

}
