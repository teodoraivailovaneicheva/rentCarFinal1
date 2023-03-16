package com.example.rentCarFinal.service;


import com.example.rentCarFinal.dto.ReservationRequest;
import com.example.rentCarFinal.dto.ReservationResponse;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    ReservationResponse addReservation(ReservationRequest reservationRequest);
    ReservationResponse getReservationById(Long id) throws RecordNotFoundException;
    List<ReservationResponse> findByCarModel(String model);
    List<ReservationResponse> getByUserEmail(String email);
    void deleteReservationById(Long id);

}