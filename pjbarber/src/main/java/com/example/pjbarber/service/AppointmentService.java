package com.example.pjbarber.service;

import com.example.pjbarber.entity.Appointment;
import com.example.pjbarber.pojo.AppointmentPojo;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(AppointmentPojo appointmentPojo);
    List<Appointment> getAllAppointment();
    Appointment getAppointmentById(Long appointment_id);
    Appointment updateAppointmentById(Long appointment_id,AppointmentPojo appointmentPojo);
    void deleteAppointmentById(Long appointment_id);



}
