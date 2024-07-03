package com.example.pjbarber.controller;

import com.example.pjbarber.entity.Barber_service;
import com.example.pjbarber.pojo.Barber_servicePojo;
import com.example.pjbarber.service.Barber_serviceService;
import com.example.pjbarber.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/barber_services")
@RequiredArgsConstructor
public class Barber_serviceController {

    private final Barber_serviceService barberServiceService;

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Barber_service>> createBarberService(@RequestBody Barber_servicePojo barber_servicePojo) {
        Barber_service barberService = barberServiceService.createBarberService(barber_servicePojo);
        GlobalApiResponse<Barber_service> response = new GlobalApiResponse<>("Successfully added", 200, barberService);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Barber_service>>> getAllBarberServices() {
        List<Barber_service> barberServices = barberServiceService.getAllBarberService();
        GlobalApiResponse<List<Barber_service>> response = new GlobalApiResponse<>("Barber services retrieved successfully", 200, barberServices);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Barber_service>> getBarberServiceById(@PathVariable("id") Long barber_service_id) {
        Optional<Barber_service> barberService = barberServiceService.getBarberServiceById(barber_service_id);
        if (barberService.isEmpty()) {
            GlobalApiResponse<Barber_service> response = GlobalApiResponse.<Barber_service>builder()
                    .message("Barber service not found with id " + barber_service_id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Barber_service> response = GlobalApiResponse.<Barber_service>builder()
                .message("Barber service retrieved successfully")
                .statusCode(HttpStatus.OK.value())
                .data(barberService.get())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Barber_service>> updateBarberServiceById(@PathVariable("id") Long barber_service_id, @RequestBody Barber_servicePojo barber_servicePojo) {
        Barber_service updatedBarberService = barberServiceService.updateBarberServiceById(barber_service_id, barber_servicePojo);
        if (updatedBarberService == null) {
            GlobalApiResponse<Barber_service> response = GlobalApiResponse.<Barber_service>builder()
                    .message("Barber service not found with id " + barber_service_id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Barber_service> response = GlobalApiResponse.<Barber_service>builder()
                .message("Barber service updated successfully")
                .statusCode(HttpStatus.OK.value())
                .data(updatedBarberService)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteBarberServiceById(@PathVariable("id") Long barber_service_id) {
        barberServiceService.deleteBarberServiceById(barber_service_id);
        GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                .message("Barber service deleted successfully")
                .statusCode(HttpStatus.NO_CONTENT.value())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}




