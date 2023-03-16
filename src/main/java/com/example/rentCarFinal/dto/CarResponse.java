package com.example.rentCarFinal.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarResponse {

    private String id;
    private String brand;
    private String model;
    private int numberOfSeats;
    private double priceADay;

}
