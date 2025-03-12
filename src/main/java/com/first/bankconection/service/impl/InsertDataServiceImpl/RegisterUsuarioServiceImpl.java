/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.InsertDataServiceImpl;

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
import com.first.bankconection.service.AbstractRegisterUsuarioService;
import com.first.bankconection.service.InterfacePersonaService;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUsuarioServiceImpl extends AbstractRegisterUsuarioService implements InterfacePersonaService<Usuario> {

    public RegisterUsuarioServiceImpl(
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
        usuario.setEstadoUsuario(EstadoUsuarioEnum.ACTIVO); // ✅ Default status: ACTIVO
        usuario.setFechaRegistro(new Date()); // ✅ Set registration date
        usuario.setFechaActualizacion(new Date()); // ✅ Set update date

        // 🔹 Hash password before saving
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));

        // 🔹 Assign User Type Based on Role
        if (usuario.getRol().getIdRol() == 2) { // Cliente
            Cliente cliente = new Cliente();
            cliente.setVerificado(true);
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
