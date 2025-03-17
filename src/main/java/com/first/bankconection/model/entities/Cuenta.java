/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.first.bankconection.model.entities.dataInit.TipoCuenta;
import com.first.bankconection.model.enums.EstadoCuentaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "cuenta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonBackReference
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cuenta", nullable = false)
    private TipoCuenta tipoCuenta;

    @Column(nullable = false, unique = true)
    private String numeroCuenta;

    private Double saldo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApertura;

    @Enumerated(EnumType.STRING)
    private EstadoCuentaEnum estadoCuenta;
    
        // ✅ New Constructor Without `idCuenta` (Auto-generated)
    public Cuenta(Cliente cliente, TipoCuenta tipoCuenta, String numeroCuenta, Double saldo, EstadoCuentaEnum estadoCuenta) {
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = new Date(); // Set current date
        this.estadoCuenta = estadoCuenta;
    }
}
