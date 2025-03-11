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
@Table(name = "seguridad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seguridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeguridad;

    @OneToOne
    @JoinColumn(name = "id_cuenta", nullable = false, unique = true)
    private Cuenta cuenta;

    private String preguntaDeSeguridad;
    private String respuestaDeSeguridad;
    private Integer intentosFallidos;
    private String tokenRecuperacion;
}
