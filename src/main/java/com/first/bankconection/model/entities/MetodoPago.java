/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.enums.TipoMetodoEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metodopago")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetodoPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_metodo", nullable = false, unique = true)
    private TipoMetodoEnum tipoMetodo;

}
