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
@Table(name = "Soporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Soporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;

    @Column(nullable = false, length = 255)
    private String asunto;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String detalle;

    @Column(nullable = false, length = 50)
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_respuesta")
    private Date fechaRespuesta;
}
