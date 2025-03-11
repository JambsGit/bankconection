/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl;

import com.first.bankconection.model.entities.Admin;
import com.first.bankconection.model.entities.dataInit.Barrio;
import com.first.bankconection.model.entities.Cliente;
import com.first.bankconection.model.entities.dataInit.Identificacion;
import com.first.bankconection.model.entities.dataInit.Nacionalidad;
import com.first.bankconection.model.entities.dataInit.Rol;
import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.repository.BarrioRepository;
import com.first.bankconection.repository.IdentificacionRepository;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.repository.RolRepository;
import com.first.bankconection.repository.UsuarioRepository;
import com.first.bankconection.service.AbstractPersonaService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends AbstractPersonaService<Usuario> {

    private final UsuarioRepository usuarioRepository;
    private final IdentificacionRepository identificacionRepository;
    private final NacionalidadRepository nacionalidadRepository;
    private final BarrioRepository barrioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Usuario crear(Usuario usuario) {
        // 🔹 Validate and set Identificacion
        Identificacion identificacion = identificacionRepository.findById(usuario.getIdentificacion().getIdIdentificacion())
                .orElseThrow(() -> new RuntimeException("❌ Error: Identificacion no encontrada"));

        // 🔹 Validate and set Nacionalidad
        Nacionalidad nacionalidad = nacionalidadRepository.findById(usuario.getNacionalidad().getIdNacionalidad())
                .orElseThrow(() -> new RuntimeException("❌ Error: Nacionalidad no encontrada"));

        // 🔹 Validate and set Barrio
        Barrio barrio = barrioRepository.findById(usuario.getBarrio().getIdBarrio())
                .orElseThrow(() -> new RuntimeException("❌ Error: Barrio no encontrado"));

        // 🔹 Validate and set Rol
        Rol rol = rolRepository.findById(usuario.getRol().getIdRol())
                .orElseThrow(() -> new RuntimeException("❌ Error: Rol no encontrado"));

        // 🔹 Set relationships
        usuario.setIdentificacion(identificacion);
        usuario.setNacionalidad(nacionalidad);
        usuario.setBarrio(barrio);
        usuario.setRol(rol);

        // 🔹 Hash password before saving
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));

        // 🔹 Determine User Type Based on Role
        if (usuario.getRol().getIdRol() == 2) {
            Cliente cliente = new Cliente();
            cliente.setVerificado(false);
            copyUserData(cliente, usuario);
            return usuarioRepository.save(cliente);
        } else if (usuario.getRol().getIdRol() == 1) {
            Admin admin = new Admin() {};
            copyUserData(admin, usuario);
            return usuarioRepository.save(admin);
        }

        // 🔹 Default Save (If Not Cliente or Admin)
        return usuarioRepository.save(usuario);
    }

    private void copyUserData(Usuario target, Usuario source) {
        target.setIdRegistro(source.getIdRegistro());
        target.setNombre(source.getNombre());
        target.setApellido(source.getApellido());
        target.setCorreo(source.getCorreo());
        target.setTelefono(source.getTelefono());
        target.setIdentificacion(source.getIdentificacion());
        target.setNumIdentificacion(source.getNumIdentificacion());
        target.setFechaNacimiento(source.getFechaNacimiento());
        target.setGenero(source.getGenero());
        target.setNacionalidad(source.getNacionalidad());
        target.setCalle(source.getCalle());
        target.setBarrio(source.getBarrio());
        target.setEstadoUsuario(source.getEstadoUsuario());
        target.setRol(source.getRol());
        target.setPasswordHash(source.getPasswordHash());
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(usuario.getNombre());
                    existing.setApellido(usuario.getApellido());
                    return usuarioRepository.save(existing);
                }).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
