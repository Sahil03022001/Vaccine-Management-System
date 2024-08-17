package com.example.VaccineManagementApplication.Repository;

import com.example.VaccineManagementApplication.Enum.DoseType;
import com.example.VaccineManagementApplication.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose, Integer> {
}