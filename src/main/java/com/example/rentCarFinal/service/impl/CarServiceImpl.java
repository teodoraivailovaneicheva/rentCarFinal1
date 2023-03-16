package com.example.rentCarFinal.service.impl;


import com.example.rentCarFinal.convertor.CarConvertor;
import com.example.rentCarFinal.dto.CarRequest;
import com.example.rentCarFinal.dto.CarResponse;
import com.example.rentCarFinal.dto.CarUpdatePriceRequest;
import com.example.rentCarFinal.entity.Car;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import com.example.rentCarFinal.repository.CarRepository;
import com.example.rentCarFinal.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarConvertor carConvertor;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarConvertor carConvertor) {

        this.carRepository = carRepository;
        this.carConvertor = carConvertor;
    }

    @Override
    public CarResponse addCar(CarRequest carRequest) {

        Car car = carConvertor.convertToCar(carRequest);
        Car carToBeSaved = carRepository.save(car);
        return carConvertor.convertToCarResponse(carToBeSaved);
    }

    @Override
    public void deleteCarById(Long id) {

        carRepository.deleteById(id);
    }

    @Override
    public CarResponse findById(Long id) throws RecordNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Car with id %s not found.", id)));
        return carConvertor.convertToCarResponse(car);
    }

    @Override
    public CarResponse updatePrice(CarUpdatePriceRequest carRequest)  {
        Car car = carRepository.findByCarModel(carRequest.getCarModel());
        car.setPriceADay(Double.parseDouble(carRequest.getUpdatedPriceADay()));
        return carConvertor.convertToCarResponse(car);
    }
}
