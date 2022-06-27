package inspired.gaming.betmanagement.service;

import java.util.List;

import inspired.gaming.betmanagement.entity.EventDetails;
import inspired.gaming.betmanagement.models.BaseResponse;

public interface EventService {
	public BaseResponse saveorUpdateEventDetails(EventDetails eventDetails);

	public BaseResponse deleteEventDetails(Integer eventId);

	public List<EventDetails> getEventDetails(Integer eventId);

}
