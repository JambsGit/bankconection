/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.service.impl;

import com.first.bankconection.model.Usuario;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.service.NacionalidadService;
import java.util.List;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NacionalidadServiceImpl implements NacionalidadService {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    @Override
    public List<Usuario> ObtenerTodos() {
        return null;    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return null;    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return null;    }

    @Override
    public Usuario actualizarUsuario(Integer id, Usuario usuario) {
        return null;    }

    @Override
    public void eliminarUsuario(Insert id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
