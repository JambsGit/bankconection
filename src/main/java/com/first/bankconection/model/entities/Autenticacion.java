/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.enums.EstadoAutenticacionEnum;
import com.first.bankconection.model.enums.TipoAutenticacionEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "autenticacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autenticacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutenticacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoAutenticacionEnum tipoAutenticacion;

    @Enumerated(EnumType.STRING)
    private EstadoAutenticacionEnum estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaAutenticacion;

    public boolean autenticar(String credencial) {
        // Lógica de autenticación
        return true; // Placeholder
    }

    public void actualizarUltimaAutenticacion() {
        this.fechaUltimaAutenticacion = new Date();
    }
}
