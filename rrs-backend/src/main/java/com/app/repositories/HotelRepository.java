package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
