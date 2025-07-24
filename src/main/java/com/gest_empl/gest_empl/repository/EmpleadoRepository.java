package com.gest_empl.gest_empl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gest_empl.gest_empl.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
