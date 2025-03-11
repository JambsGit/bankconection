/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "beneficiario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBeneficiario;

    @Column(nullable = false)
    private String nombreBeneficiario;

    @Column(nullable = false, unique = true)
    private String numeroCuentaBeneficiario;

    @Column(nullable = false)
    private String bancoBeneficiario;
}
