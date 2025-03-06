/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model;

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
    private Integer idBarrio;

    @Column(name = "nombre_barrio", nullable = false, unique = true,  length = 100)
    private String nombreBarrio;
    
    // Constructor for inserting data without ID (let DB generate it)
    public Barrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }
}
