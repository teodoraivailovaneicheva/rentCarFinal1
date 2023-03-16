package com.example.rentCarFinal.controller;


import com.example.rentCarFinal.convertor.CarConvertor;
import com.example.rentCarFinal.dto.CarRequest;
import com.example.rentCarFinal.dto.CarResponse;
import com.example.rentCarFinal.dto.CarUpdatePriceRequest;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import com.example.rentCarFinal.service.CarService;
import com.example.rentCarFinal.service.impl.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarConvertor carConvertor;

    @Autowired
    private CarServiceImpl carServiceImpl;
    @Autowired
    public CarController(CarService carService, CarConvertor carConvertor,CarServiceImpl carServiceImpl ){

        this.carService = carService;
        this.carConvertor = carConvertor;
        this.carServiceImpl = carServiceImpl;
    }

    //Add new car
    @PostMapping("/addCar")
    ResponseEntity<CarResponse> addCar(@Valid @RequestBody CarRequest carRequest) throws SQLIntegrityConstraintViolationException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carService.addCar(carRequest));
    }

    //Get car by id
    @GetMapping("/getCarById/{id}")
    ResponseEntity<CarResponse> getCarById(@PathVariable Long id) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(carService.findById(id));
    }

    //Update car
    @PutMapping("/updateCar")
    ResponseEntity<CarResponse> updatePrice(@Valid @RequestBody CarUpdatePriceRequest carRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.updatePrice(carRequest));
    }


    //Delete car
    @DeleteMapping("/deleteCarById/{id}")
    public ResponseEntity deleteCarById(@PathVariable Long id){
        carService.deleteCarById(id);
        return ResponseEntity.ok().build();
    }
}

