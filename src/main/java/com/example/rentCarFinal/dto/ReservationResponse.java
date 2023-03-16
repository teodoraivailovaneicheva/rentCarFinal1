package com.example.rentCarFinal.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Component
public class ReservationResponse {

    private Long id;
    private String model;
    private String email;

}
