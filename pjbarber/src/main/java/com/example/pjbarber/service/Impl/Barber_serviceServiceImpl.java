package com.example.pjbarber.service.Impl;


import com.example.pjbarber.entity.Barber_service;
import com.example.pjbarber.pojo.Barber_servicePojo;
import com.example.pjbarber.repository.Barber_serviceRepository;
import com.example.pjbarber.service.BarberService;
import com.example.pjbarber.service.Barber_serviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class Barber_serviceServiceImpl implements Barber_serviceService {

    private final Barber_serviceRepository barberServiceRepository;



    //   ======for getting all information at onec=====  getmapping
    @Override
    public List<Barber_service> getAllBarberService() {
        return barberServiceRepository.findAll() ;
    }
//   ==by id =====  getmapping{/"id"}
    @Override
    public Optional<Barber_service> getBarberServiceById(Long barber_service_id) {
        return barberServiceRepository.findById(barber_service_id) ;
    }

    @Override
    public Barber_service createBarberService(Barber_servicePojo barberServicePojo) {
        return null;
    }

    //    ======save or update====   postmapping and putmapping
    @Override
    public Barber_service updateBarberServiceById(Long barber_service_id, Barber_servicePojo barberServicePojo) {
        Barber_service barberService = new Barber_service();
        barberService.setStatus(barberServicePojo.getStatus());
        return barberServiceRepository.save(barberService) ;
    }
//  ======delete mapping =====
    @Override
    public void deleteBarberServiceById(Long barber_service_id) {
        barberServiceRepository.deleteById(barber_service_id) ;

    }
}
