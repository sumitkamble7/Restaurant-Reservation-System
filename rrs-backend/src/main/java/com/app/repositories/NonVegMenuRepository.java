package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.NonVegMenu;

public interface NonVegMenuRepository extends JpaRepository<NonVegMenu, Integer>{

	
	@Query("SELECT v FROM NonVegMenu v WHERE v.hotel.id = :hotelId")
	List<NonVegMenu> getHotelNonVegMenu(int hotelId);

}
