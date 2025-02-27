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
@Table(name = "Barrio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Barrio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_barrio;

    @Column(name = "nombre_barrio", nullable = false, unique = true,  length = 100)
    private String nombreBarrio;
}
