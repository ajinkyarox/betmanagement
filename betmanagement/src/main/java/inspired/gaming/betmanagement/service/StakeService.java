package inspired.gaming.betmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import inspired.gaming.betmanagement.entity.StakeDetails;
import inspired.gaming.betmanagement.models.BaseResponse;

@Service
public interface StakeService {

	public BaseResponse saveorUpdateStakeDetails(StakeDetails stakeDetails);
	public List<StakeDetails> getStakeDetails(Integer stakeId);
	public BaseResponse deleteStakeDetails(Integer stakeId);
	
	
}