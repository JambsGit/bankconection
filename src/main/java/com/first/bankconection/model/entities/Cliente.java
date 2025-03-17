/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.first.bankconection.model.enums.TipoClienteEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario {

    @Enumerated(EnumType.STRING)
    private TipoClienteEnum tipoCliente;

    private boolean verificado;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Cuenta cuenta;  // ✅ Add One-to-One Relationship with Cuenta
}
