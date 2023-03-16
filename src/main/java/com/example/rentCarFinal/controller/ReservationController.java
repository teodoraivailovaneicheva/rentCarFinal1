package com.example.rentCarFinal.controller;


import com.example.rentCarFinal.dto.ReservationRequest;
import com.example.rentCarFinal.dto.ReservationResponse;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import com.example.rentCarFinal.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    //Add new reservation
    @PostMapping("/addReservation")
    ResponseEntity<ReservationResponse> addReservation(@RequestBody ReservationRequest reservationRequest) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservationService.addReservation(reservationRequest));
    }

    //Get reservation by id
    @GetMapping("/getReservationById/{id}")
    ResponseEntity<ReservationResponse> getReservationById(@PathVariable Long id) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(reservationService.getReservationById(id));
    }

    //Get reservation by user
    @GetMapping("/getReservationByUser/{user}")
    ResponseEntity<List<ReservationResponse>> getReservationByUser(@PathVariable String email) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(reservationService.getByUserEmail(email));
    }

    //Get reservation by car
    @GetMapping("/getReservationByCar/{car}")
    ResponseEntity<List<ReservationResponse>> getReservationByCar(@PathVariable String model) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(reservationService.findByCarModel(model));
    }

    //Delete reservation
    @DeleteMapping("/deleteReservationById/{id}")
    ResponseEntity<String> deleteReservationById(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity
                .ok()
                .body(String.format("%d deleted", id));
    }
}

