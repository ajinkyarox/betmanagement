package inspired.gaming.betmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inspired.gaming.betmanagement.entity.MarketDetails;

public interface MarketRepository extends JpaRepository<MarketDetails, Integer> {

}
