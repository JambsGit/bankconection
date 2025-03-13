/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.ManagementClientServiceImpl;

import com.first.bankconection.dto.ChangePasswordRequest;
import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.model.enums.EstadoUsuarioEnum;
import com.first.bankconection.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdatePasswordClientServiceImpl {

    protected final UsuarioRepository usuarioRepository;
    protected final PasswordEncoder passwordEncoder;

    @Transactional
    public Optional<Usuario> cambiarPassword(ChangePasswordRequest request, Integer userId) {
        // ✅ Find user by ID
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(userId);

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("❌ Error: Usuario no encontrado.");
        }

        Usuario usuario = usuarioOpt.get();

        // ✅ Ensure the user is a client
        if (usuario.getRol().getIdRol() != 2) {
            throw new RuntimeException("❌ Error: Solo los clientes pueden cambiar la contraseña.");
        }

        // ✅ Ensure the user is changing their own password
        if (!usuario.getCorreo().equals(request.getCorreo())) {
            throw new RuntimeException("❌ Error: No puede cambiar la contraseña de otro usuario.");
        }

        // ✅ Verify old password
        if (!passwordEncoder.matches(request.getOldPassword(), usuario.getPasswordHash())) {
            throw new RuntimeException("❌ Error: La contraseña actual es incorrecta.");
        }

        // ✅ Ensure the new password is different from the old password
        if (passwordEncoder.matches(request.getNewPassword(), usuario.getPasswordHash())) {
            throw new RuntimeException("❌ Error: La nueva contraseña no puede ser igual a la anterior.");
        }

        // ✅ Hash and update new password
        usuario.setPasswordHash(passwordEncoder.encode(request.getNewPassword()));
        usuario.setEstadoUsuario(EstadoUsuarioEnum.ACTIVO); // ✅ Activate user
        usuario.setFechaActualizacion(new Date()); // ✅ Update modification date

        return Optional.of(usuarioRepository.save(usuario));
    }
}
