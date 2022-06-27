package inspired.gaming.betmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inspired.gaming.betmanagement.entity.EventDetails;

public interface EventRepository  extends JpaRepository<EventDetails, Integer> {

	
	EventDetails findByEventId(Integer eventId);
}
