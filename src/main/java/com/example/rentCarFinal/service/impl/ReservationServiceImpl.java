package com.example.rentCarFinal.service.impl;


import com.example.rentCarFinal.convertor.ReservationConvertor;
import com.example.rentCarFinal.dto.ReservationRequest;
import com.example.rentCarFinal.dto.ReservationResponse;
import com.example.rentCarFinal.entity.Reservation;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import com.example.rentCarFinal.repository.CarRepository;
import com.example.rentCarFinal.repository.ReservationRepository;
import com.example.rentCarFinal.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationConvertor convertor;
    private final CarRepository carRepository;
    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationConvertor convertor, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.convertor = convertor;
        this.carRepository = carRepository;
    }

    @Override
    public ReservationResponse addReservation(ReservationRequest reservationRequest) {
        Reservation reservation = convertor.toReservationRequest(reservationRequest);
        Reservation reservationToBeSaved = reservationRepository.save(reservation);
        return convertor.toResponse(reservationToBeSaved);
    }

    @Override
    public ReservationResponse getReservationById(Long id) throws RecordNotFoundException {
        return convertor.toResponse(reservationRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Reservation with ID " + id + " not found")));
    }

    @Override
    public List<ReservationResponse> findByCarModel(String model) {
        return reservationRepository.findByCarModel(model)
                .stream()
                .map(convertor::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationResponse> getByUserEmail(String email) {
        return reservationRepository.findByUserEmail(email)
                .stream()
                .map(convertor::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReservationById(Long id) {

        reservationRepository.deleteById(id);

    }

}

