package inspired.gaming.betmanagement.service;

import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.models.BaseResponse;

@Service
public interface BetOutcomeService {

	public BaseResponse calculateWinnings(Integer eventId, String token);
	
	public BaseResponse getWinnings(Integer eventId, String token);
	
	
}
