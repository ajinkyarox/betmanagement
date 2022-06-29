package inspired.gaming.betmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import inspired.gaming.betmanagement.entity.StakeDetails;

public interface StakeRepository extends JpaRepository<StakeDetails, Integer> {

	StakeDetails findByStakeId(@Param("stakeId") Integer stakeId);

	List<StakeDetails> findByEventId(@Param("eventId") Integer eventId);

	List<StakeDetails> findByEventIdAndMarketId(@Param("eventId") Integer eventId, @Param("marketId") Integer marketId);
}
