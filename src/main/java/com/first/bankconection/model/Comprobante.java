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
@Table(name = "Comprobante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComprobante;

    @OneToOne
    @JoinColumn(name = "id_transaccion", nullable = false)
    private Transaccion transaccion;

    @Column(name = "url_comprobante", nullable = false, unique = true, length = 255)
    private String urlComprobante;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_generacion", updatable = false)
    private Date fechaGeneracion;
}
