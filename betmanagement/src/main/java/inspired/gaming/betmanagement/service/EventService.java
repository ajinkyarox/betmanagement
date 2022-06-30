package inspired.gaming.betmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.EventDetails;
import inspired.gaming.betmanagement.models.BaseResponse;

@Service
public interface EventService {
	public BaseResponse saveorUpdateEventDetails(EventDetails eventDetails, String token);

	public BaseResponse deleteEventDetails(Integer eventId, String token);

	public List<EventDetails> getEventDetails(Integer eventId, String token);

}
