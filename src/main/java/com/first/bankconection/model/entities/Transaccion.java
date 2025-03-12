/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.model.entities;

/**
 *
 * @author Intraway
 */
import com.first.bankconection.model.entities.dataInit.MetodoPago;
import com.first.bankconection.model.abstractClasses.ProcesoTransaccion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Transaccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaccion extends ProcesoTransaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion") // ¡Define el nombre correcto!
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    private Cuenta cuenta;

    @OneToOne
    @JoinColumn(name = "id_beneficiario", nullable = false)
    private Beneficiario beneficiario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_transaccion", nullable = false)
    private TipoTransaccion tipoTransaccion;

    @OneToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;
    
    @OneToOne
    @JoinColumn(name = "id_tarjeta")
    private Tarjeta tarjeta;

    @Column(nullable = false)
    private Double monto;

    @Override
    public void procesar() {
        System.out.println("Procesando transacción por un monto de: " + monto);
    }
}
