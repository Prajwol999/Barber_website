package com.example.pjbarber.service;

import com.example.pjbarber.entity.Barber_service;
import com.example.pjbarber.pojo.Barber_servicePojo;

import java.util.List;
import java.util.Optional;

public interface Barber_serviceService {

    List<Barber_service> getAllBarberService();
    Optional<Barber_service> getBarberServiceById(Long barber_service_id);
    Barber_service createBarberService(Barber_servicePojo barberServicePojo);
    Barber_service updateBarberServiceById(Long barber_service_id, Barber_servicePojo barberServicePojo);
    void deleteBarberServiceById(Long barber_service_id);

}
