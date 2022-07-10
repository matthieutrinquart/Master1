package repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
	
	
	

}
