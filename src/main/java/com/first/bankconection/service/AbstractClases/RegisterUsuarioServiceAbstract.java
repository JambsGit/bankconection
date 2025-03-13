/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service;

import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.model.entities.dataInit.Barrio;
import com.first.bankconection.model.entities.dataInit.Identificacion;
import com.first.bankconection.model.entities.dataInit.Nacionalidad;
import com.first.bankconection.model.entities.dataInit.Rol;
import com.first.bankconection.repository.BarrioRepository;
import com.first.bankconection.repository.IdentificacionRepository;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.repository.RolRepository;
import com.first.bankconection.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class RegisterUsuarioServiceAbstract {

    protected final UsuarioRepository usuarioRepository;
    protected final IdentificacionRepository identificacionRepository;
    protected final NacionalidadRepository nacionalidadRepository;
    protected final BarrioRepository barrioRepository;
    protected final RolRepository rolRepository;
    protected final PasswordEncoder passwordEncoder;
    
    

    // 🔹 Common method to validate foreign keys and return objects
    protected Identificacion validateIdentificacion(String id) {
        return identificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Error: Identificación no encontrada"));
    }

    protected Nacionalidad validateNacionalidad(String id) {
        return nacionalidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Error: Nacionalidad no encontrada"));
    }

    protected Barrio validateBarrio(Integer id) {
        return barrioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Error: Barrio no encontrado"));
    }

    protected Rol validateRol(Integer id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Error: Rol no encontrado"));
    }

    // 🔹 Validate unique constraints before creating/updating
    protected void checkUniqueFields(Usuario usuario) {
        if (usuarioRepository.findByIdRegistro(usuario.getIdRegistro()).isPresent()) {
            throw new RuntimeException("❌ Error: El idRegistro '" + usuario.getIdRegistro() + "' ya está en uso.");
        }
        if (usuarioRepository.findByNumIdentificacion(usuario.getNumIdentificacion()).isPresent()) {
            throw new RuntimeException("❌ Error: El numIdentificacion '" + usuario.getNumIdentificacion() + "' ya está en uso.");
        }
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new RuntimeException("❌ Error: El correo '" + usuario.getCorreo() + "' ya está en uso.");
        }
        if (usuarioRepository.findByTelefono(usuario.getTelefono()).isPresent()) {
            throw new RuntimeException("❌ Error: El teléfono '" + usuario.getTelefono() + "' ya está en uso.");
        }
        
    }

    // 🔹 Common method to copy user data (avoiding repetition)
    protected void copyUserData(Usuario target, Usuario source) {
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
}

