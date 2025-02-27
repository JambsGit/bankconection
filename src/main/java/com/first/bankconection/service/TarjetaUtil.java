/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service;

import com.first.bankconection.model.Tarjeta;
public class TarjetaUtil {

    public static Tarjeta createDummyTarjeta() {
        return Tarjeta.builder()
            .tipoTarjeta("Crédit2")
            .numeroTarjeta("1234123412341266")
            .fechaEmision("")
            .fechaVencimiento("")
            .estadoTarjeta("activa")
            .build();
    }
}
