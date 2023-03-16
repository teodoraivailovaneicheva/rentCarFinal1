package com.example.rentCarFinal.repository;


import com.example.rentCarFinal.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserEmail(String email);

    List<Reservation> findByCarModel(String model);

}

