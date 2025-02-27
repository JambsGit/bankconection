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
@Table(name = "Seguridad")
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

    @Column(name = "pregunta_de_seguridad", nullable = false, length = 255)
    private String preguntaDeSeguridad;

    @Column(name = "respuesta_de_seguridad", nullable = false, length = 255)
    private String respuestaDeSeguridad;

    @Column(name = "intentos_fallidos", nullable = false)
    private Integer intentosFallidos;

    @Column(name = "token_recuperacion", length = 255)
    private String tokenRecuperacion;
}
