/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.service.impl.ManagementClientServiceImpl.RegisterClientServiceImpl;
import jakarta.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClientRegisterController {

    private final RegisterClientServiceImpl usuarioService;

    // 🔹 Create a client (Only if idRol = 2)
    @PostMapping("/crear")
    public ResponseEntity<?> crearCliente(@RequestBody Usuario usuario) {
        try {
            // 🔹 Validate that only clients can be created
            if (usuario.getRol().getIdRol() != 2) {
                return ResponseEntity.badRequest().body(
                        Collections.singletonMap("error", "❌ Solo se pueden registrar clientes"));
            }

            // 🔹 Call service to create client
            Usuario nuevoUsuario = usuarioService.crear(usuario);
            return ResponseEntity.ok(nuevoUsuario);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    Collections.singletonMap("error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerClientePorId(@PathVariable Integer id) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerPorId(id);

        // ✅ Check if user exists
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Collections.singletonMap("error", "❌ Error: Cliente no encontrado."));
        }

        Usuario usuario = usuarioOpt.get();

        // ✅ Validate that the user is a client (idRol = 2)
        if (usuario.getRol().getIdRol() != 2) {
            return ResponseEntity.badRequest().body(
                    Collections.singletonMap("error", "❌ Error: El usuario no es un cliente."));
        }

        return ResponseEntity.ok(usuario);
    }

    // 🔹 Update a client (Only if idRol = 2)
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> actualizarCliente(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Optional<Usuario> existingUser = usuarioService.obtenerPorId(id);

        // ✅ Check if user exists
        if (existingUser.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Collections.singletonMap("error", "❌ Error: Cliente no encontrado."));
        }

        Usuario cliente = existingUser.get();

        // ✅ Validate that only clients can be updated
        if (cliente.getRol().getIdRol() != 2) {
            return ResponseEntity.badRequest().body(
                    Collections.singletonMap("error", "❌ Solo se pueden actualizar clientes"));
        }

        // ✅ Update user fields
        usuarioService.actualizar(id, usuario);
        return ResponseEntity.ok(Collections.singletonMap("message", "✅ Cliente actualizado correctamente."));
    }

    // 🔹 Delete a client (Only if idRol = 2)
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer id) {
        Optional<Usuario> existingUser = usuarioService.obtenerPorId(id);

        // ✅ Check if user exists
        if (existingUser.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Collections.singletonMap("error", "❌ Error: Cliente no encontrado."));
        }

        Usuario cliente = existingUser.get();

        // ✅ Validate that only clients can be deleted
        if (cliente.getRol().getIdRol() != 2) {
            return ResponseEntity.badRequest().body(
                    Collections.singletonMap("error", "❌ Solo se pueden eliminar clientes"));
        }

        usuarioService.eliminarPorId(id);
        return ResponseEntity.ok(Collections.singletonMap("message", "✅ Cliente eliminado correctamente."));
    }
}
