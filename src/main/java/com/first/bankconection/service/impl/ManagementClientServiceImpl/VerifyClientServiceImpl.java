/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.ManagementClientServiceImpl;

import com.first.bankconection.model.entities.Cliente;
import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerifyClientServiceImpl {

    protected final UsuarioRepository usuarioRepository;

    @Transactional
    public Optional<Cliente> verificarCliente(Integer id, boolean verificado) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("❌ Error: Cliente no encontrado.");
        }

        Usuario usuario = usuarioOpt.get();

        // ✅ Ensure only clients can be verified
        if (!(usuario instanceof Cliente)) {
            throw new RuntimeException("❌ Error: Solo los clientes pueden ser verificados.");
        }

        Cliente cliente = (Cliente) usuario;
        cliente.setVerificado(verificado);  // ✅ Set verification status
        cliente.setFechaActualizacion(new Date()); // ✅ Update modification date

        return Optional.of(usuarioRepository.save(cliente));
    }
}
