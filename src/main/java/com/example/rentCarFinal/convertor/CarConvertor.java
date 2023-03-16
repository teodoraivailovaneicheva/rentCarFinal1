package com.example.rentCarFinal.convertor;


import com.example.rentCarFinal.dto.CarRequest;
import com.example.rentCarFinal.dto.CarResponse;
import com.example.rentCarFinal.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConvertor {

    public Car convertToCar(CarRequest carRequest){
        return Car.builder()
                .brand(carRequest.getBrand())
                .model(carRequest.getModel())
                .numberOfSeats(carRequest.getNumberOfSeats())
                .priceADay(carRequest.getPriceADay())
                .build();
    }

    public CarResponse convertToCarResponse(Car car){
        return CarResponse.builder()
                .id(car.getId().toString())
                .model(car.getModel())
                .numberOfSeats(car.getNumberOfSeats())
                .priceADay(car.getPriceADay())
                .build();
    }
}