/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

import com.first.bankconection.model.abstractClasses.Persona;
import com.first.bankconection.model.entities.dataInit.Rol;
import com.first.bankconection.model.enums.EstadoUsuarioEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "usuario")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario extends Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario") 
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private String idRegistro;

    @Enumerated(EnumType.STRING)
    private EstadoUsuarioEnum estadoUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    private String passwordHash;
}