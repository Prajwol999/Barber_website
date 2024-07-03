package com.example.pjbarber.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Barber_servicePojo {

    private Long barber_service_id;
    private String status;
    private Long barber_id;
    private Long service_id;
    private Long appointment_id;


}
