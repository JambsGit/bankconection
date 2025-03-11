/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.interfaces.Autenticable;
import com.first.bankconection.model.enums.EstadoAutenticacion;
import com.first.bankconection.model.enums.TipoAutenticacion;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "autenticacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autenticacion implements Autenticable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutenticacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoAutenticacion tipoAutenticacion;

    @Enumerated(EnumType.STRING)
    private EstadoAutenticacion estado;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaAutenticacion;

    @Override
    public boolean autenticar(String credencial) {
        // Lógica de autenticación
        return true; // Placeholder
    }

    @Override
    public void actualizarUltimaAutenticacion() {
        this.fechaUltimaAutenticacion = new Date();
    }
}
