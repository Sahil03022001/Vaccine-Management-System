package com.example.VaccineManagementApplication.Repository;

import com.example.VaccineManagementApplication.Models.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCentreRepository extends JpaRepository<VaccinationCentre, Integer> {
}
