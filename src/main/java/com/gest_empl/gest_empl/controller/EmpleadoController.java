package com.gest_empl.gest_empl.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gest_empl.gest_empl.model.Empleado;
import com.gest_empl.gest_empl.service.IEmpleadoService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    /**
     * GET /api/empleados
     * Obtiene la lista de todos los empleados
     * @return Lista de empleados con código 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        try {
            List<Empleado> empleados = empleadoService.getEmpleados();
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * GET /api/empleados/{id}
     * Busca un empleado por su ID
     * @param id ID del empleado a buscar
     * @return Empleado encontrado (200) o Not Found (404)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Integer id) {
        try {
            Empleado empleado = empleadoService.getEmpleado(id);
            if (empleado != null) {
                return ResponseEntity.ok(empleado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * POST /api/empleados
     * Crea un nuevo empleado
     * @param empleado Datos del empleado a crear
     * @return Empleado creado con código 201 CREATED
     */
    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        try {
            // Validación básica
            if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            // Asegurar que es una creación (sin ID)
            empleado.setId(null);
            
            Empleado empleadoGuardado = empleadoService.saveEmpleado(empleado);
            if (empleadoGuardado != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(empleadoGuardado);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * PUT /api/empleados/{id}
     * Actualiza un empleado existente
     * @param id ID del empleado a actualizar
     * @param empleado Nuevos datos del empleado
     * @return Empleado actualizado (200) o Not Found (404)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(
            @PathVariable Integer id, 
            @RequestBody Empleado empleado) {
        try {
            // Validación básica
            if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            // Verificar que el empleado existe antes de actualizar
            Empleado empleadoExistente = empleadoService.getEmpleado(id);
            if (empleadoExistente == null) {
                return ResponseEntity.notFound().build();
            }
            
            // Asegurar que se actualiza el empleado correcto
            empleado.setId(id);
            
            Empleado empleadoActualizado = empleadoService.saveEmpleado(empleado);
            if (empleadoActualizado != null) {
                return ResponseEntity.ok(empleadoActualizado);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * DELETE /api/empleados/{id}
     * Elimina un empleado por su ID
     * @param id ID del empleado a eliminar
     * @return No Content (204) si se eliminó, Not Found (404) si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {
        try {
            // Verificar que el empleado existe
            Empleado empleado = empleadoService.getEmpleado(id);
            if (empleado == null) {
                return ResponseEntity.notFound().build();
            }
            
            boolean eliminado = empleadoService.deleteEmpleado(empleado);
            if (eliminado) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
