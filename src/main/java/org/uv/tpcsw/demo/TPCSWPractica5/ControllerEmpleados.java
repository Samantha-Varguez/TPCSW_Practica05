
package org.uv.tpcsw.demo.TPCSWPractica5;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/empleados")
public class ControllerEmpleados {
    
    // permite hacer implementacion automatica 
    @Autowired
   
    private RepositoryEmpleado repositoryEmpleados;
    
    @GetMapping()
    public List<Empleado> list() {
         //jpa implementa el findall
        return repositoryEmpleados.findAll();
    }
    
    @GetMapping("/{id}")
    public Empleado get(@PathVariable long id) {
        Optional<Empleado> res= repositoryEmpleados.findById(id);
        return res.get();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Empleado empleado) {
          Optional<Empleado> resEmp = repositoryEmpleados.findById(id);
        if (!resEmp.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Empleado empleadoExisted = resEmp.get();

        empleadoExisted.setNombre(empleado.getNombre());
        empleadoExisted.setTelefono(empleado.getTelefono());
        empleadoExisted.setDireccion(empleado.getDireccion());
        
        repositoryEmpleados.save(empleadoExisted);
        return new ResponseEntity<>(empleadoExisted, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Empleado empleado) {
        Empleado empRes = repositoryEmpleados.save(empleado);
        return new ResponseEntity<Empleado>(empRes, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Empleado> delete(@PathVariable long id)  {
        Optional<Empleado> resEmp = repositoryEmpleados.findById(id);

        if (!resEmp.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repositoryEmpleados.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}