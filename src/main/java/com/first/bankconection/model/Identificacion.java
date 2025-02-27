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
@Table(name = "Identificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Identificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_identificacion;

    @Column(name = "tipo_identificacion", nullable = false, unique = true,  length = 50)
    private String tipoIdentificacion;
}
