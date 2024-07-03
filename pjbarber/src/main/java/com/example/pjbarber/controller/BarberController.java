package com.example.pjbarber.controller;


import com.example.pjbarber.entity.Appointment;
import com.example.pjbarber.entity.Barber;
import com.example.pjbarber.entity.Customer;
import com.example.pjbarber.pojo.BarberPojo;
import com.example.pjbarber.pojo.CustomerPojo;
import com.example.pjbarber.service.BarberService;
import com.example.pjbarber.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbers")
@RequiredArgsConstructor

public class BarberController {

    private final BarberService barberService;

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Barber>> getBarber(@RequestBody BarberPojo barberPojo) {
        Barber barber = barberService.getBarber(barberPojo);
        GlobalApiResponse<Barber> response = new GlobalApiResponse<>("successfully added", 200, barber);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Barber>>> getAllBarber() {
        List<Barber> barber = barberService.getAllBarber();
        GlobalApiResponse<List<Barber>> response = new GlobalApiResponse<>("barber retrieved successfully",200,barber);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Barber>> getBarberById(@PathVariable("id") Long barber_id) {
        Barber barber = barberService.getBarberById(barber_id);
        if (barber == null) {
            GlobalApiResponse<Barber> response = GlobalApiResponse.<Barber>builder()
                    .message("Barber not found with id " + barber_id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Barber> response = GlobalApiResponse.<Barber>builder()
                .message("Barber retrieved successfully")
                .statusCode(HttpStatus.OK.value())
                .data(barber)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Barber>> updateBarberById(@PathVariable("id") Long barber_id, @RequestBody BarberPojo barberPojo) {
        Barber updatedBarber = barberService.updateBarberById(barber_id, barberPojo);
        if (updatedBarber == null) {
            GlobalApiResponse<Barber> response = GlobalApiResponse.<Barber>builder()
                    .message("Barber not found with id " + barber_id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Barber> response = GlobalApiResponse.<Barber>builder()
                .message("Barber updated successfully")
                .statusCode(HttpStatus.OK.value())
                .data(updatedBarber)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteAppointmentById(@PathVariable Long id) {
        barberService.deleteBarberById(id);
        GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                .message("appointment deleted successfully")
                .statusCode(HttpStatus.NO_CONTENT.value())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }







}

