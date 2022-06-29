package inspired.gaming.betmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.MarketDetails;
import inspired.gaming.betmanagement.models.BaseResponse;

@Service
public interface MarketService {

	public BaseResponse saveorUpdateMarketDetails(MarketDetails marketDetails);
	public List<MarketDetails> getMarketDetails(Integer marketId);
	public BaseResponse deleteMarketDetails(Integer marketId);
	
	
}
