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

@Entity
@Table(name = "TipoCuenta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoCuenta;

    @Column(name = "nombre_tipo_cuenta", nullable = false, unique = true, length = 50)
    private String nombreTipoCuenta;
}
