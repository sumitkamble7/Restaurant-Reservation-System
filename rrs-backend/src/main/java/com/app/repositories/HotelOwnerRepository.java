package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entities.HotelOwner;
import com.app.entities.User;

public interface HotelOwnerRepository extends JpaRepository<HotelOwner, Integer>{
	HotelOwner findByEmail(String email);
}
