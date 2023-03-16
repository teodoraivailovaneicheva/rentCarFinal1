package com.example.rentCarFinal.convertor;


import com.example.rentCarFinal.dto.ReservationRequest;
import com.example.rentCarFinal.dto.ReservationResponse;
import com.example.rentCarFinal.entity.Car;
import com.example.rentCarFinal.entity.Reservation;
import com.example.rentCarFinal.entity.User;
import com.example.rentCarFinal.repository.CarRepository;
import com.example.rentCarFinal.repository.ReservationRepository;
import com.example.rentCarFinal.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ReservationConvertor {

    ReservationRepository reservationRepository;
    UserRepository userRepository;
    CarRepository carRepository;

    public ReservationConvertor(ReservationRepository reservationRepository,UserRepository userRepository,CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    public Reservation toReservationRequest(ReservationRequest reservationRequest){
        User user = userRepository.findByEmail(reservationRequest.getEmail());
        Car car = carRepository.findByCarModel(reservationRequest.getModel());
        return Reservation.builder()
                .user(user)
                .car(car)
                .date(Instant.now())
                .build();
    }

    public ReservationResponse toResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .model(reservation.getCar().getModel())
                .email(reservation.getUser().getEmail())
                .build();
    }
}