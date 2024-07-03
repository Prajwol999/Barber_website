package com.example.pjbarber.repository;

import com.example.pjbarber.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BarberRepository extends JpaRepository<Barber, Long> {
}
