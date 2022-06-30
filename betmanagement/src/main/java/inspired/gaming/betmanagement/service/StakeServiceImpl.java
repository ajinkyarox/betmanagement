package inspired.gaming.betmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.StakeDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.repository.StakeRepository;

@Service
public class StakeServiceImpl implements StakeService {

	@Autowired
	StakeRepository stakeRepository;

	@Autowired
	private LoggingService loggingService;
	
	@Override
	public BaseResponse saveorUpdateStakeDetails(StakeDetails stakeDetails) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(Constants.SUCCESSSTATUS);
		try {
			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			if (validateMarketDetails(stakeDetails)) {
				stakeRepository.save(stakeDetails);
			} else {
				baseResponse.setMessage("Please provide all the details for the Event.");
			}
			loggingService.log("INFO", "Outside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
		} catch (Exception e) {
			loggingService.log("ERROR", "Inside Exception"+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			baseResponse.setMessage(e.getMessage());

		}

		return baseResponse;
	}

	@Override
	public List<StakeDetails> getStakeDetails(Integer stakeId) {

		List<StakeDetails> listOfStakeDetails = new ArrayList<StakeDetails>();

		try {

			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			if (stakeId == null || stakeId == 0) {
				listOfStakeDetails = stakeRepository.findAll();
			} else {
				StakeDetails stakeDetails = stakeRepository.findByStakeId(stakeId);
				listOfStakeDetails.add(stakeDetails);
			}
			loggingService.log("INFO", "Outside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
		} catch(Exception e) {
			loggingService.log("ERROR", "Inside Exception"+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
		}
		
		return listOfStakeDetails;
	}

	@Override
	public BaseResponse deleteStakeDetails(Integer stakeId) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(Constants.SUCCESSSTATUS);
		try {

			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			StakeDetails stakeDetails = stakeRepository.findByStakeId(stakeId);
			if (stakeDetails != null) {
				stakeRepository.delete(stakeDetails);
			} else {
				baseResponse.setMessage("Please provide all the details for the Event.");
			}
			loggingService.log("INFO", "Outside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
		} catch (Exception e) {
			loggingService.log("ERROR", "Inside Exception"+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			baseResponse.setMessage(e.getMessage());

		}

		return baseResponse;
	}

	public boolean validateMarketDetails(StakeDetails stakeDetails) {

		boolean flag = false;
		if (stakeDetails != null) {
			if (stakeDetails.getEventId() != null && stakeDetails.getMarketId() != null
					&& stakeDetails.getStakeAmount() != null && stakeDetails.getUserId() != null) {
				flag = true;
			}

		}

		return flag;

	}

}
