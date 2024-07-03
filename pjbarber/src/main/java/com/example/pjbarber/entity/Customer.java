package com.example.pjbarber.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_id_generator")
    @SequenceGenerator(name="customer_id_generator",sequenceName = "customer_seq",allocationSize=1)
    private Long customer_id;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "phone_no", length = 15)
    private Long phoneNumber;
}
