package inspired.gaming.betmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.EventDetails;
import inspired.gaming.betmanagement.entity.MarketDetails;
import inspired.gaming.betmanagement.entity.StakeDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.repository.EventRepository;
import inspired.gaming.betmanagement.repository.MarketRepository;
import inspired.gaming.betmanagement.repository.StakeRepository;

@Service
public class BetOutcomeServiceImpl implements BetOutcomeService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	StakeRepository stakeRepository;
	
	@Autowired
	MarketRepository marketRepository;

	@Override
	public BaseResponse calculateWinnings(Integer eventId) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		try {
			EventDetails eventDetails = eventRepository.findByEventId(eventId);
			List<StakeDetails> listOfStakes = stakeRepository.findByEventId(eventId);

			Integer totalAmount = 0;
			Integer totalWinSideAmount = 0;

			for (StakeDetails sdTemp : listOfStakes) {

				totalAmount += sdTemp.getStakeAmount();
				

			}
			eventDetails.setTotalBetAmount(totalAmount);
			eventRepository.save(eventDetails);
			
			MarketDetails wonMarket = marketRepository.findByEventIdAndWinst(eventId,"WON");
			
			List<StakeDetails> wonStakesList = stakeRepository.findByEventIdAndMarketId(eventId,wonMarket.getMarketId());
			
			for (StakeDetails sdTemp : wonStakesList) {
				totalWinSideAmount+=sdTemp.getStakeAmount();
			}
			List<StakeDetails> updateSDObj = new ArrayList<StakeDetails>();
			for (StakeDetails sdTemp : wonStakesList) {
				Integer wonAmount = ((sdTemp.getStakeAmount()/totalWinSideAmount)*totalAmount);
				sdTemp.setAmountWon(wonAmount);
				updateSDObj.add(sdTemp);
			}
			stakeRepository.saveAll(updateSDObj);
			baseResponse.setMessage("Winnings calculated Successfully.");
		} catch (Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}

		return baseResponse;
	}

	@Override
	public BaseResponse getWinnings(Integer eventId) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		try {
		MarketDetails marketDetails = marketRepository.findByEventIdAndWinst(eventId, "WON");	
		List<StakeDetails> listOfWinnings = stakeRepository.findByEventIdAndMarketId(eventId, marketDetails.getMarketId());
		baseResponse.setMessage("Winnings Extracted Successfully.");
		baseResponse.setListOfSDObjects(listOfWinnings);
		} catch(Exception e) {
			baseResponse.setMessage(e.getMessage());
			baseResponse.setStatus(Constants.SUCCESSSTATUS);
		}
		
		return baseResponse;
	}
	
	

}
