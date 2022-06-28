package inspired.gaming.betmanagement.service;

import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.models.BaseResponse;

@Service
public interface BetOutcomeService {

	public BaseResponse calculateWinnings(Integer eventId);
	
}
