/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.enums.TipoClienteEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario {

    @Enumerated(EnumType.STRING)
    private TipoClienteEnum tipoCliente;

    private boolean verificado;
}
