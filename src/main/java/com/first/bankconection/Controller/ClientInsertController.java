/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.service.impl.RegisterUsuarioServiceImpl;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClientInsertController {

    private final RegisterUsuarioServiceImpl usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearCliente(@RequestBody Usuario usuario) {
        try {
            // 🔹 Validate that only clients can be created
            if (usuario.getRol().getIdRol() != 2) {
                return ResponseEntity.badRequest().body(
                        Collections.singletonMap("error", "❌ Solo se pueden registrar clientes con idRol = 2"));
            }

            // 🔹 Call service to create client
            Usuario nuevoUsuario = usuarioService.crear(usuario);
            return ResponseEntity.ok(nuevoUsuario);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    Collections.singletonMap("error", e.getMessage()));
        }
    }
}
