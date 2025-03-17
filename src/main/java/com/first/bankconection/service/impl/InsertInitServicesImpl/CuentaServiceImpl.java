/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.InsertInitServicesImpl;

import com.first.bankconection.model.entities.Cuenta;
import com.first.bankconection.repository.ClienteRepository;
import com.first.bankconection.repository.CuentaRepository;
import com.first.bankconection.service.Interfaces.CuentaService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public Optional<Cuenta> obtenerCuentaPorClienteId(Integer idCliente) {
        return clienteRepository.findById(idCliente)
                .flatMap(cliente -> cuentaRepository.findByCliente(cliente));
    }
}
