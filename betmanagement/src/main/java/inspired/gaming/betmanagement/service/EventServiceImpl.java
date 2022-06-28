package inspired.gaming.betmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.AccountDetails;
import inspired.gaming.betmanagement.entity.EventDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.repository.AccountDetailsRepository;
import inspired.gaming.betmanagement.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Override
	public BaseResponse saveorUpdateEventDetails(EventDetails eventDetails) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(Constants.SUCCESSSTATUS);
		try {
			if (validateEventDetails(eventDetails)) {
				eventRepository.save(eventDetails);
			}

			else {
				baseResponse.setMessage("Please provide all the details for the Event.");
			}
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());

		}

		return baseResponse;
	}

	@Override
	public List<EventDetails> getEventDetails(Integer eventId) {

		List<EventDetails> listOfEventDetails = new ArrayList<EventDetails>();

		if (eventId == null || eventId == 0) {
			listOfEventDetails = eventRepository.findAll();
		} else {
			EventDetails eventDetails = eventRepository.findByEventId(eventId);
			listOfEventDetails.add(eventDetails);
		}
		return listOfEventDetails;
	}

	@Override
	public BaseResponse deleteEventDetails(Integer eventId) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(Constants.SUCCESSSTATUS);
		try {
			EventDetails eventDetails = eventRepository.findByEventId(eventId);
			if (eventDetails != null) {
				eventRepository.delete(eventDetails);
			} else {
				baseResponse.setMessage("Please provide all the details for the Event.");
			}
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());

		}

		return baseResponse;
	}

	public boolean validateEventDetails(EventDetails eventDetails) {

		boolean flag = false;
		if (eventDetails != null) {
			if (eventDetails.getEventname() != null && eventDetails.getEventname().trim().equals("")
					&& eventDetails.getEventDescription() != null
					&& eventDetails.getEventDescription().trim().equals("") && eventDetails.getStartDateTime() != null
					&& eventDetails.getEndDateTime() != null) {
				flag = true;
			}

		}

		return flag;

	}

}
