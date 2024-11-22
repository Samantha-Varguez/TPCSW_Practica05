package org.uv.tpcsw.demo.TPCSWPractica5;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
            generator = "departamentos_clave_seq")
    @SequenceGenerator(name = "departamentos_clave_seq",
            sequenceName = "departamentos_clave_seq",
            initialValue = 1, allocationSize = 1)
   
    @Column(name = "clave")
    private long clave;
    private String nombre;
    
  @JsonIgnore
    @OneToMany(mappedBy = "depto", fetch = FetchType.EAGER)
    private Set<Empleado> empleados = new HashSet<>();

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}