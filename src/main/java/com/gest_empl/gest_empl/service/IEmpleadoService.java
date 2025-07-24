package com.gest_empl.gest_empl.service;

import java.util.List;

import com.gest_empl.gest_empl.model.Empleado;

public interface IEmpleadoService {
    List<Empleado> getEmpleados();
    Empleado getEmpleado(int id);

    Empleado saveEmpleado(Empleado e);
    boolean deleteEmpleado(Empleado e);
}
