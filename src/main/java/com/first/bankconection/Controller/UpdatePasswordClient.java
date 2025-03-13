/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.dto.ChangePasswordRequest;
import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.service.impl.ManagementClientServiceImpl.UpdatePasswordClientServiceImpl;
import jakarta.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class UpdatePasswordClient {

    private final UpdatePasswordClientServiceImpl clientPasswordService;

    @PutMapping("/cambiar-password")
    @Transactional
    public ResponseEntity<?> cambiarPassword(@RequestBody ChangePasswordRequest request, @RequestHeader("User-ID") Integer userId) {
        try {
            Optional<Usuario> usuarioOpt = clientPasswordService.cambiarPassword(request, userId);

            if (usuarioOpt.isEmpty()) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "❌ Error: No se pudo cambiar la contraseña."));
            }

            return ResponseEntity.ok(Collections.singletonMap("message", "✅ Contraseña cambiada con éxito. Ahora su cuenta está activa."));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }

}
