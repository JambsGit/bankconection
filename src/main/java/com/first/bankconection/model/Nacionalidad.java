/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author Intraway
 */ 
@Entity
@Table(name = "Nacionalidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nacionalidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nacionalidad;

    @Column(name = "nombre_nacionalidad", nullable = false, unique = true,  length = 50)
    private String nombreNacionalidad;
}
    
