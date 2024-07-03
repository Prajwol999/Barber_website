package com.example.pjbarber.service;

import com.example.pjbarber.entity.Barber;
import com.example.pjbarber.pojo.BarberPojo;

import java.util.List;

public interface BarberService {

    Barber getBarber(BarberPojo barberPojo);
    List<Barber> getAllBarber();
    Barber getBarberById(Long barber_id);
    Barber updateBarberById(Long barber_id, BarberPojo barberPojo);
    void deleteBarberById(Long barber_id);





}
