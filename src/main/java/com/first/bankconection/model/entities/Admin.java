/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

import com.first.bankconection.model.enums.AreaResponsabilidadEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("ADMIN")
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Usuario {

    @Enumerated(EnumType.STRING)
    private AreaResponsabilidadEnum areaResponsabilidad;

    private boolean verificado;

}
