package com.example.rentCarFinal.service;

import com.example.rentCarFinal.dto.CarRequest;
import com.example.rentCarFinal.dto.CarResponse;
import com.example.rentCarFinal.dto.CarUpdatePriceRequest;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface CarService {


    CarResponse addCar(CarRequest carRequest);

    void deleteCarById(Long id);

    CarResponse findById(Long id)throws RecordNotFoundException;
    CarResponse updatePrice(CarUpdatePriceRequest carRequest);


}