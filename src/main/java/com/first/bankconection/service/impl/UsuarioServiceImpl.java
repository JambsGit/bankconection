/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl;

import com.first.bankconection.dto.UsuarioDTO;
import com.first.bankconection.model.Barrio;
import com.first.bankconection.model.Identificacion;
import com.first.bankconection.model.Nacionalidad;
import com.first.bankconection.model.Rol;
import com.first.bankconection.model.Usuario;
import com.first.bankconection.repository.BarrioRepository;
import com.first.bankconection.repository.IdentificacionRepository;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.repository.RolRepository;
import com.first.bankconection.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends InsertarDatosServiceImpl<Usuario, Integer> {

    private final IdentificacionRepository identificacionRepository;
    private final NacionalidadRepository nacionalidadRepository;
    private final BarrioRepository barrioRepository;
    private final RolRepository rolRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario actualizar(Integer id, Usuario entity) {
        Usuario usuarioBBDD = usuarioRepository.findById(id).orElse(null);
        if (usuarioBBDD != null) {
            usuarioBBDD.setIdUsuario(entity.getIdUsuario());
            usuarioRepository.save(usuarioBBDD);
        }
        return usuarioBBDD;
    }

    @Override
    public List<Usuario> obtenerTodo() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario crear(Usuario entity) {
        return usuarioRepository.save(entity);
    }

     @Transactional
    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        // Fetch Identificacion
        Identificacion identificacion = identificacionRepository.findById(usuarioDTO.getIdIdentificacion())
                .orElseThrow(() -> new RuntimeException("❌ Identificacion not found!"));

        // Fetch Nacionalidad
        Nacionalidad nacionalidad = nacionalidadRepository.findById(usuarioDTO.getIdNacionalidad())
                .orElseThrow(() -> new RuntimeException("❌ Nacionalidad not found!"));

        // Fetch Barrio
        Barrio barrio = barrioRepository.findById(usuarioDTO.getIdBarrio())
                .orElseThrow(() -> new RuntimeException("❌ Barrio not found!"));

        // Fetch Rol
        Rol rol = rolRepository.findById(usuarioDTO.getIdRol())
                .orElseThrow(() -> new RuntimeException("❌ Rol not found!"));

        // Create Usuario
        Usuario usuario = Usuario.builder()
                .idRegistro(usuarioDTO.getIdRegistro())
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .correo(usuarioDTO.getCorreo())
                .telefono(usuarioDTO.getTelefono())
                .identificacion(identificacion)
                .numIdentificacion(usuarioDTO.getNumIdentificacion())
                .fechaNacimiento(usuarioDTO.getFechaNacimiento())
                .genero(usuarioDTO.getGenero())
                .nacionalidad(nacionalidad)
                .calle(usuarioDTO.getCalle())
                .barrio(barrio)
                .estadoUsuario(usuarioDTO.getEstadoUsuario())
                .rol(rol)
                .passwordHash(usuarioDTO.getPasswordHash())
                .build();

        return usuarioRepository.save(usuario);
    }
    @Override
    protected List<Usuario> getInitialData() {
        return null;
    }

    @Override
    protected void saveAllEntities(List<Usuario> entities) {
    }

    @Override
    protected long getEntityCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
