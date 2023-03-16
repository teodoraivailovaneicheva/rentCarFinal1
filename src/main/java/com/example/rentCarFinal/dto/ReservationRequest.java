package com.example.rentCarFinal.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ReservationRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String model;
    @NotBlank
    private Instant date;

}