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
@Table(name = "Beneficiario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBeneficiario;

    @Column(name = "nombre_beneficiario", nullable = false, length = 100)
    private String nombreBeneficiario;

    @Column(name = "numero_cuenta_beneficiario", nullable = false, unique = true, length = 20)
    private String numeroCuentaBeneficiario;

    @Column(name = "banco_beneficiario", nullable = false, length = 100)
    private String bancoBeneficiario;
}
