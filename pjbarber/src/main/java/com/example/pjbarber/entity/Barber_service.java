package com.example.pjbarber.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name ="barber_services")
@Entity

public class Barber_service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "barber_service_setup_seq_gen")
    @SequenceGenerator(name="barber_service_setup_seq_gen",sequenceName ="barber_service__setup_seq",allocationSize=1 )
    private Long barber_service_id;



    @Column(name="status",length = 10)
    private String status;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "barber_id",referencedColumnName = "barber_id",nullable = false,foreignKey =
    @ForeignKey(name="fk_barber_id"))
    private Barber barber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id",referencedColumnName = "service_id",nullable = false,foreignKey =
    @ForeignKey(name="fk_service_id"))
    private Service service;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id",referencedColumnName = "appointment_id",nullable = false,foreignKey =
    @ForeignKey(name="fk_appointment_id"))
    private Appointment appointment;





}
