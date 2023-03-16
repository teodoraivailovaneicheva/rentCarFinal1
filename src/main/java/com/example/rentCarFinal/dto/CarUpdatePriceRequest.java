package com.example.rentCarFinal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarUpdatePriceRequest {

    @NotNull
    private String carModel;

    @NotNull
    private String currentPriceADay;

    @NotNull
    private String updatedPriceADay;
}