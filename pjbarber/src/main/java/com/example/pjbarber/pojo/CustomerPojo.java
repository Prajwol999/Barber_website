package com.example.pjbarber.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerPojo {

    private Long customerId;
    private Long password;
    private String fullName;
    private Long phoneNumber;
    private String email;

}
