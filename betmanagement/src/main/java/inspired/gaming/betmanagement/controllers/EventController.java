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

import inspired.gaming.betmanagement.entity.EventDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.EventService;

@RestController
public class EventController {

	@Autowired
	EventService eventService;

	@PostMapping(path = "/saveorUpdateEventDetails")
	public ResponseEntity<BaseResponse> saveorUpdateEventDetails(@RequestBody EventDetails eventDetails) {

		BaseResponse baseResponse = null;

		try {
			baseResponse = eventService.saveorUpdateEventDetails(eventDetails);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/getEventDetails")
	public ResponseEntity<BaseResponse> getEventDetails(@RequestParam("eventId") Integer eventId) {
		BaseResponse baseResponse = new BaseResponse();
		List<EventDetails> listOfEventDetails = null;
		try {
			listOfEventDetails = eventService.getEventDetails(eventId);
			baseResponse.setListOfEDObjects(listOfEventDetails);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@DeleteMapping("/deleteEventDetails")
	public ResponseEntity<BaseResponse> deleteEventDetails(@RequestParam("eventId") Integer eventId) {
		BaseResponse baseResponse = null;
		try {
			baseResponse = eventService.deleteEventDetails(eventId);
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);

	}

}
