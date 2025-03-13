/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.model.entities.Cliente;
import com.first.bankconection.service.impl.ManagementClientServiceImpl.RegisterClientServiceImpl;
import jakarta.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class VerifyClientController {

    private final RegisterClientServiceImpl clientVerifyService;

    @PutMapping("/verificar/{id}")
    @Transactional
    public ResponseEntity<?> verificarCliente(@PathVariable Integer id, @RequestParam boolean verificado) {
        try {
            Optional<Cliente> clienteOpt = clientVerifyService.verificarCliente(id, verificado);

            if (clienteOpt.isEmpty()) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "❌ Error: No se pudo verificar al cliente."));
            }

            return ResponseEntity.ok(Collections.singletonMap("message", "✅ Estado de verificación actualizado correctamente."));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
