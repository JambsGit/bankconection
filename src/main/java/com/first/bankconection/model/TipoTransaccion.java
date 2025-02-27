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
@Table(name = "TipoTransaccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoTransaccion;

    @Column(name = "tipo_de_transaccion", nullable = false, unique = true, length = 50)
    private String tipoDeTransaccion;
}
