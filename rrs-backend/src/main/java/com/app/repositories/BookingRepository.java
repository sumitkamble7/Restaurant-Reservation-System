package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("SELECT b FROM Booking b WHERE b.hotel.hotel_id = :hotel_id")
	List<Booking> findByHotel_Id(int hotel_id);

}
