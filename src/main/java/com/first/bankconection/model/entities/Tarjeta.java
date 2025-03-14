/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.enums.TipoTarjetaEnum;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@Entity
@Table(name = "tarjeta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarjeta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tarjeta",nullable = false)
    private TipoTarjetaEnum tipoTarjeta;

    @Column(nullable = false, unique = true)
    private String numeroTarjeta;

    @Column(nullable = false)
    private Date fechaEmision;

    @Column(nullable = false)
    private Date fechaVencimiento;

    @Column(nullable = false)
    private String estadoTarjeta;
}
