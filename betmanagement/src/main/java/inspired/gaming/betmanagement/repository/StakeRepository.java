package inspired.gaming.betmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inspired.gaming.betmanagement.entity.StakeDetails;

public interface StakeRepository extends JpaRepository<StakeDetails, Integer> {

}
