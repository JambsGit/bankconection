/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities.dataInit;

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
@Builder
public class Nacionalidad {
    
    @Id
    @Column(name = "id_nacionalidad")
    private String idNacionalidad; 

    @Column(name = "nombre_nacionalidad", nullable = false, unique = true,  length = 50)
    private String nombreNacionalidad;
}
    
