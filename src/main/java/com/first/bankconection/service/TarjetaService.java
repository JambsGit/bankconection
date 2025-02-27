/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service;

import com.first.bankconection.model.*;
import com.first.bankconection.repository.TarjetaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {

    private final TarjetaRepository tarjetaRepository;

    public TarjetaService(TarjetaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    public Tarjeta createTarjeta() {
        Tarjeta tarjeta = TarjetaUtil.createDummyTarjeta();
        return tarjetaRepository.save(tarjeta);
    }
}
