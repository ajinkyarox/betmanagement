package inspired.gaming.betmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import inspired.gaming.betmanagement.entity.MarketDetails;
import inspired.gaming.betmanagement.entity.StakeDetails;

public interface MarketRepository extends JpaRepository<MarketDetails, Integer> {

	MarketDetails findByMarketId(@Param("marketId") Integer marketId);
	
	List<MarketDetails> findByEventId(@Param("eventId") Integer eventId);
	

	MarketDetails findByEventIdAndStatusOfMarket(@Param("eventId") Integer eventId,
			@Param("statusOfMarket") String statusOfMarket);

}
