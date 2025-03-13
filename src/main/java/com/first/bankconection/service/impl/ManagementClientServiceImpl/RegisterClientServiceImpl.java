/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.ManagementClientServiceImpl;

import com.first.bankconection.model.entities.Admin;
import com.first.bankconection.model.entities.Cliente;
import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.model.enums.AreaResponsabilidadEnum;
import com.first.bankconection.model.enums.EstadoUsuarioEnum;
import com.first.bankconection.model.enums.TipoClienteEnum;
import com.first.bankconection.repository.BarrioRepository;
import com.first.bankconection.repository.IdentificacionRepository;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.repository.RolRepository;
import com.first.bankconection.repository.UsuarioRepository;
import com.first.bankconection.service.RegisterUsuarioServiceAbstract;
import com.first.bankconection.service.Interfaces.InterfacePersonaService;
import jakarta.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterClientServiceImpl extends RegisterUsuarioServiceAbstract implements InterfacePersonaService<Usuario> {

    public RegisterClientServiceImpl(
            UsuarioRepository usuarioRepository,
            IdentificacionRepository identificacionRepository,
            NacionalidadRepository nacionalidadRepository,
            BarrioRepository barrioRepository,
            RolRepository rolRepository,
            PasswordEncoder passwordEncoder) {
        super(usuarioRepository, identificacionRepository, nacionalidadRepository, barrioRepository, rolRepository, passwordEncoder);
    }

    @Override
    @Transactional
    public Usuario crear(Usuario usuario) {
        // 🔹 Check for unique fields
        checkUniqueFields(usuario);

        // 🔹 Validate and set foreign keys
        usuario.setIdentificacion(validateIdentificacion(usuario.getIdentificacion().getIdIdentificacion()));
        usuario.setNacionalidad(validateNacionalidad(usuario.getNacionalidad().getIdNacionalidad()));
        usuario.setBarrio(validateBarrio(usuario.getBarrio().getIdBarrio()));
        usuario.setRol(validateRol(usuario.getRol().getIdRol()));

        // 🔹 Set default values
        usuario.setEstadoUsuario(EstadoUsuarioEnum.INACTIVO); // ✅ Default status: ACTIVO
        usuario.setFechaRegistro(new Date()); // ✅ Set registration date
        usuario.setFechaActualizacion(new Date()); // ✅ Set update date

        // 🔹 Generate and set temporary password
        String tempPassword = generateTemporaryPassword();
        usuario.setPasswordHash(passwordEncoder.encode(tempPassword));

        // 🔹 Log password (For debugging, should be sent via email in production)
        System.out.println("🔹 Temporary password for " + usuario.getCorreo() + " -> " + tempPassword);

        // 🔹 Assign User Type Based on Role
        if (usuario.getRol().getIdRol() == 2) { // Cliente
            Cliente cliente = new Cliente();
            cliente.setVerificado(false);
            cliente.setTipoCliente(TipoClienteEnum.REGULAR);
            copyUserData(cliente, usuario);
            return usuarioRepository.save(cliente);
        } else if (usuario.getRol().getIdRol() == 1) { // Admin
            Admin admin = new Admin();
            admin.setVerificado(true);
            admin.setAreaResponsabilidad(AreaResponsabilidadEnum.GENERAL);
            copyUserData(admin, usuario);
            return usuarioRepository.save(admin);
        }

        return usuarioRepository.save(usuario);
    }

    /**
     * 🔹 Generates a secure random temporary password.
     */
    private String generateTemporaryPassword() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[8]; // Generates a random 8-byte (64-bit) password
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

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

    @Override
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Usuario> actualizar(Integer id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id).map(existingUser -> {
            copyUserData(existingUser, usuarioActualizado);
            existingUser.setFechaActualizacion(new Date()); // ✅ Update modification date
            return usuarioRepository.save(existingUser);
        });
    }

    @Override
    @Transactional
    public Optional<Boolean> eliminarPorId(Integer id) {
        return usuarioRepository.findById(id).map(user -> {
            usuarioRepository.deleteById(id);
            return true;
        });
    }
}
