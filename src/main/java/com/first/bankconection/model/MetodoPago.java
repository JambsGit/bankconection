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
@Table(name = "MetodoPago")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetodoPago;

    @Column(name = "tipo_de_metodo", nullable = false, length = 50)
    private String tipoDeMetodo;

    @OneToOne
    @JoinColumn(name = "id_tarjeta", referencedColumnName = "idTarjeta")
    private Tarjeta tarjeta;
}
