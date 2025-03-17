/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.model.entities.Cuenta;
import com.first.bankconection.service.Interfaces.CuentaService;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cuenta")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @GetMapping("/{idCliente}")
    public ResponseEntity<?> obtenerCuenta(@PathVariable Integer idCliente) {
        Optional<Cuenta> cuentaOpt = cuentaService.obtenerCuentaPorClienteId(idCliente);

        if (cuentaOpt.isPresent()) {
            return ResponseEntity.ok(cuentaOpt.get());
        } else {
            return ResponseEntity.ok(Collections.singletonMap("error", "❌ No se encontró una cuenta para el cliente con ID " + idCliente));
        }
    }
}

