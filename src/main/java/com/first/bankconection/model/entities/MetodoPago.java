/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.enums.TipoDeMetodo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metodopago")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetodoPago;

    @Column(nullable = false)
    private TipoDeMetodo tipoDeMetodo;

    @OneToOne
    @JoinColumn(name = "id_tarjeta")
    private Tarjeta tarjeta;
}
