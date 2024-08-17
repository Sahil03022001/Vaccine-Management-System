package com.example.VaccineManagementApplication.Repository;

import com.example.VaccineManagementApplication.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
