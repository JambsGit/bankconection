/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.abstractClasses.ProcesoTransaccion;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Comprobante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comprobante extends ProcesoTransaccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "id_transaccion", nullable = false)
    private Transaccion transaccion;

    @Column(nullable = false, unique = true)
    private String urlComprobante;

    @Override
    public void procesar() {
        System.out.println("Generando comprobante para la transacción: "+urlComprobante);
    }
}