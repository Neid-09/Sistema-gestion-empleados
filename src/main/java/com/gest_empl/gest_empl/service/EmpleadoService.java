package com.gest_empl.gest_empl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gest_empl.gest_empl.model.Empleado;
import com.gest_empl.gest_empl.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRespository){
        this.empleadoRepository = empleadoRespository;
    }

    @Override
    public List<Empleado> getEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleado(int id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado saveEmpleado(Empleado e) {
        return empleadoRepository.save(e);
    }

    @Override
    public boolean deleteEmpleado(Empleado e) {
        if (empleadoRepository.existsById(e.getId())) {
            empleadoRepository.delete(e);
            return true;
        } else {
            return false;
            
        }
    }
}
