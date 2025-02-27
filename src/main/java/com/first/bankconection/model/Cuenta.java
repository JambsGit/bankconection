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
@Table(name = "Cuenta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cuenta", nullable = false)
    private TipoCuenta tipoCuenta;

    @Column(name = "numero_cuenta", nullable = false, unique = true, length = 20)
    private String numeroCuenta;

    @Column(nullable = false)
    private Double saldo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_apertura", updatable = false)
    private Date fechaApertura;

    @Column(name = "estado_cuenta", nullable = false, length = 50)
    private String estadoCuenta;
}
