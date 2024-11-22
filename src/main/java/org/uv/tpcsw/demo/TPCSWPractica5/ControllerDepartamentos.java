
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
@RequestMapping("/api/Departamentos")
public class ControllerDepartamentos {
    @Autowired
    private RepositoryDepartamentos repositoryDepartamentos;
    @GetMapping()
    public List<Departamento> list() {
        return (List<Departamento>) repositoryDepartamentos.findAll();
    }
    @GetMapping("/{id}")
    public Object get(@PathVariable long id) {
        return repositoryDepartamentos.findById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Departamento> put(@PathVariable long id, @RequestBody Departamento departamento) {
        Optional< Departamento> resDepto = repositoryDepartamentos.findById(id);

        if (!resDepto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Departamento deptoExisted = resDepto.get();
        deptoExisted.setNombre(departamento.getNombre());
        repositoryDepartamentos.save(deptoExisted);
        return new ResponseEntity<>(deptoExisted, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Departamento> post(@RequestBody Departamento depto) {
        Departamento response = repositoryDepartamentos.save(depto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Departamento> delete(@PathVariable long id) {
        Optional<Departamento> resDepto = repositoryDepartamentos.findById(id);
        if(!resDepto.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repositoryDepartamentos.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}