package com.example.rentCarFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserUpdatePassword {

    @NotNull
    private Long id;

    @NotNull
    private String password;

    @NotNull
    private String newPassword;
}

