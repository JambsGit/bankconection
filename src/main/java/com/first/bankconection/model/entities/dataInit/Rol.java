/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities.dataInit;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.enums.TipoRolEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Rol")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rol {

    @Id
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol", nullable = false, unique = true, length = 50)
    private TipoRolEnum nombreRol;

}
