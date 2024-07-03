package com.example.pjbarber.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appointment_setup_seq_gen")
    @SequenceGenerator(name="appointment_setup_seq_gen",sequenceName ="appointment_setup_seq",allocationSize=1 )
    private Long appointment_id;

    @Column(name ="appointmentDate",length = 7)
    private LocalDate appointmentDate;

    @Column(name="appointmentTime",length = 7)
    private LocalTime appointmentTime;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="customer_id",referencedColumnName = "customer_id", nullable = false,foreignKey =
    @ForeignKey(name="fk_customer_id"))
    private Customer customer;


}
