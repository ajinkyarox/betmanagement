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

import inspired.gaming.betmanagement.entity.EventDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.service.EventService;
import inspired.gaming.betmanagement.service.Logging;
import inspired.gaming.betmanagement.service.LoggingService;

@RestController
public class EventController {

	@Autowired
	EventService eventService;

	@Autowired
	private Logging loggingService;
	
	@PostMapping(path = "/saveorUpdateEventDetails")
	public ResponseEntity<BaseResponse> saveorUpdateEventDetails(@RequestBody EventDetails eventDetails,
			@RequestHeader("Authorization") String token) {

		BaseResponse baseResponse = null;

		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse = eventService.saveorUpdateEventDetails(eventDetails,token);
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

	@GetMapping(path = "/getEventDetails")
	public ResponseEntity<BaseResponse> getEventDetails(@RequestParam("eventId") Integer eventId,
			@RequestHeader("Authorization") String token) {
		BaseResponse baseResponse = new BaseResponse();
		List<EventDetails> listOfEventDetails = null;
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			listOfEventDetails = eventService.getEventDetails(eventId,token);
			baseResponse.setListOfEDObjects(listOfEventDetails);
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

	@DeleteMapping("/deleteEventDetails")
	public ResponseEntity<BaseResponse> deleteEventDetails(@RequestParam("eventId") Integer eventId,
			@RequestHeader("Authorization") String token) {
		BaseResponse baseResponse = null;
		try {
			loggingService.log("INFO", "Inside " + new Object() {
			}.getClass().getEnclosingMethod().getName(), token);
			baseResponse = eventService.deleteEventDetails(eventId,token);
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
