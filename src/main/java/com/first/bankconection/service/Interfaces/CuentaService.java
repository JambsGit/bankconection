/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.Interfaces;

import com.first.bankconection.model.entities.Cuenta;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface CuentaService {
    Optional<Cuenta> obtenerCuentaPorClienteId(Integer idCliente);
}
