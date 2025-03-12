/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities.dataInit;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.enums.TipoCuentaEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipocuenta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_tipo_cuenta", nullable = false, unique = true)
    private TipoCuentaEnum nombreTipoCuenta;
}
