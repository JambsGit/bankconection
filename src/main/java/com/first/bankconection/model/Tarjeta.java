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

//import java.util.Date;

@Entity
@Table(name = "Tarjeta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarjeta;

    @Column(name = "tipo_tarjeta", nullable = false, length = 50)
    private String tipoTarjeta;

    @Column(name = "numero_tarjeta", nullable = false, unique = true, length = 16)
    private String numeroTarjeta;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision", nullable = false)
    private String fechaEmision;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento", nullable = false)
    private String fechaVencimiento;

    @Column(name = "estado_tarjeta", nullable = false, length = 50)
    private String estadoTarjeta;

}
