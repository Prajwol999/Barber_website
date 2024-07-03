package com.example.pjbarber.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "barbers")
@Getter
@Setter
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "barber_id_generator")
    @SequenceGenerator(name="barber_id_generator",sequenceName = "barber_seq",allocationSize=1)
    private Long barber_id;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "phone_no", length = 15)
    private Long phoneNumber;


}
