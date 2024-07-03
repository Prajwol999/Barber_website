package com.example.pjbarber.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BarberPojo {

    private Long barberId;
    private String email;
    private String fullName;
    private Long phone;
    private String password;



}
