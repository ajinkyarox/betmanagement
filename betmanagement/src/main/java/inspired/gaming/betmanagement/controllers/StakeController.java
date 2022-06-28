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

import inspired.gaming.betmanagement.entity.StakeDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.StakeService;

@RestController
public class StakeController {

	@Autowired
	StakeService stakeService;

	@PostMapping(path = "/saveorUpdateMarketDetails")
	public ResponseEntity<BaseResponse> saveorUpdateMarketDetails(@RequestBody StakeDetails stakeDetails) {

		BaseResponse baseResponse = null;

		try {
			baseResponse = stakeService.saveorUpdateStakeDetails(stakeDetails);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/getStakeDetails")
	public ResponseEntity<BaseResponse> getMarketDetails(@RequestParam("stakeId") Integer stakeId) {
		BaseResponse baseResponse = new BaseResponse();
		List<StakeDetails> listOfStakeDetails = null;
		try {
			listOfStakeDetails = stakeService.getStakeDetails(stakeId);
			baseResponse.setListOfSDObjects(listOfStakeDetails);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@DeleteMapping("/deleteStakeDetails")
	public ResponseEntity<BaseResponse> deleteStakeDetails(@RequestParam("stakeId") Integer stakeId) {
		BaseResponse baseResponse = null;
		try {
			baseResponse = stakeService.deleteStakeDetails(stakeId);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);

	}

}
