/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model;

/**
 *
 * @author Intraway
 */
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "id_registro", nullable = false, unique = true, length = 50)
    private String idRegistro;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, unique = true, length = 20)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_identificacion", nullable = false)
    private Identificacion identificacion;

    @Column(nullable = false, unique = true, length = 50)
    private String numIdentificacion;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false, length = 10)
    private String genero;

    @ManyToOne
    @JoinColumn(name = "id_nacionalidad", nullable = false)
    private Nacionalidad nacionalidad;

    @Column(nullable = false, length = 150)
    private String calle;

    @ManyToOne
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrio barrio;

    @Column(name = "estado_usuario", nullable = false, length = 50)
    private String estadoUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro", updatable = false)
    private Date fechaRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
}
