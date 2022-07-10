package repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Exception.HotelsNotFoundException;
import models.*;
public interface HotelRepository extends JpaRepository<Hotel,Long>{

	
	

}
