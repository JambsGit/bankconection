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
@Table(name = "Autenticacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autenticacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutenticacion;

    @Column(name = "tipo_autenticacion", nullable = false, length = 50)
    private String tipoAutenticacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 50)
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_ultima_autenticacion", updatable = false)
    private Date fechaUltimaAutenticacion;
}
