/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.enums.EstadoCuentaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "cuenta")
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

    @Column(nullable = false, unique = true)
    private String numeroCuenta;

    private Double saldo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApertura;

    @Enumerated(EnumType.STRING)
    private EstadoCuentaEnum estadoCuenta;
}
