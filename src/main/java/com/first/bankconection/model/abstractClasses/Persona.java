/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.abstractClasses;

import com.first.bankconection.model.entities.dataInit.Barrio;
import com.first.bankconection.model.entities.dataInit.Identificacion;
import com.first.bankconection.model.entities.dataInit.Nacionalidad;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona {

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_identificacion", nullable = false)
    private Identificacion identificacion;

    private String numIdentificacion;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String genero;

    @ManyToOne
    @JoinColumn(name = "id_nacionalidad", nullable = false)
    private Nacionalidad nacionalidad;

    private String calle;

    @ManyToOne
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrio barrio;
}
