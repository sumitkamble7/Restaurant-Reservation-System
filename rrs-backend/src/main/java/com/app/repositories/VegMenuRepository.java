package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.VegMenu;

public interface VegMenuRepository extends JpaRepository<VegMenu, Integer> {

	@Query("SELECT v FROM VegMenu v WHERE v.hotel.id = :hotelId")
	List<VegMenu> getHotelVegMenu(int hotelId);

}
