package com.example.pjbarber.service.Impl;

import com.example.pjbarber.entity.Barber;
import com.example.pjbarber.pojo.BarberPojo;
import com.example.pjbarber.repository.BarberRepository;
import com.example.pjbarber.service.BarberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class BarberServiceImpl implements BarberService {

    private final BarberRepository barberRepository;


    @Override
    public Barber getBarber(BarberPojo barberPojo) {
        Barber barber = new Barber();
        barber.setFullName(barberPojo.getFullName());
        barber.setEmail(barberPojo.getEmail());
        barber.setPhoneNumber(barberPojo.getPhone());
        barber.setPassword(barberPojo.getPassword());
        return barber;
    }

    @Override
    public List<Barber> getAllBarber() {
        return barberRepository.findAll();
    }

    @Override
    public Barber getBarberById(Long barber_id) {
        return barberRepository.findById(barber_id).orElse(null);
    }

    @Override
    public Barber updateBarberById(Long barber_id, BarberPojo barberPojo) {

        Optional<Barber> barber = barberRepository.findById(barber_id);
        if(barber.isPresent()) {
            barber.get().setFullName(barberPojo.getFullName());
            barber.get().setEmail(barberPojo.getEmail());
            barber.get().setPhoneNumber(barberPojo.getPhone());
            barber.get().setPassword(barberPojo.getPassword());
            return barberRepository.save(barber.get());
        }else{
            return null;
        }

    }

    @Override
    public void deleteBarberById(Long barber_id) {
        barberRepository.deleteById(barber_id);

    }
}
