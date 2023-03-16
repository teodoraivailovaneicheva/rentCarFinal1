package com.example.rentCarFinal.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CarRequest {

    @NotNull
    private String model;
    @NotNull
    private String brand;
    @NotNull
    private int numberOfSeats;
    @NotNull
    private double priceADay;

}