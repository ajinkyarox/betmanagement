package inspired.gaming.betmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.MarketDetails;
import inspired.gaming.betmanagement.models.BaseResponse;
import inspired.gaming.betmanagement.other.Constants;
import inspired.gaming.betmanagement.repository.MarketRepository;

@Service
public class MarketServiceImpl implements MarketService {

	@Autowired
	MarketRepository marketRepository;
	
	@Autowired
	private LoggingService loggingService;

	@Override
	public BaseResponse saveorUpdateMarketDetails(MarketDetails marketDetails) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(Constants.SUCCESSSTATUS);
		try {
			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			if (validateMarketDetails(marketDetails)) {
				marketRepository.save(marketDetails);
			} else {
				baseResponse.setMessage("Please provide all the details for the Event.");
			}
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
	public List<MarketDetails> getMarketDetails(Integer marketId) {

		
		List<MarketDetails> listOfMarketDetails = new ArrayList<MarketDetails>();
		try {
			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			if (marketId == null || marketId == 0) {
				listOfMarketDetails = marketRepository.findAll();
			} else {
				MarketDetails marketDetails = marketRepository.findByMarketId(marketId);
				listOfMarketDetails.add(marketDetails);
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
		
		return listOfMarketDetails;
	}

	@Override
	public BaseResponse deleteMarketDetails(Integer marketId) {
		// TODO Auto-generated method stub
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(Constants.SUCCESSSTATUS);
		try {
			loggingService.log("INFO", "Inside "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName(), 0);
			MarketDetails marketDetails = marketRepository.findByMarketId(marketId);
			if (marketDetails != null) {
				marketRepository.delete(marketDetails);
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

	public boolean validateMarketDetails(MarketDetails marketDetails) {

		boolean flag = false;
		if (marketDetails != null) {
			if (marketDetails.getMarketname() != null && !marketDetails.getMarketname().trim().equals("")
					&& marketDetails.getMarketdescription() != null
					&& !marketDetails.getMarketdescription().trim().equals("")) {
				flag = true;
			}

		}

		return flag;

	}

}
