/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.service;

import com.first.bankconection.model.Usuario;
import java.util.List;
import org.hibernate.sql.Insert;

/**
 *
 * @author Intraway
 */
public interface NacionalidadService {

    List<Usuario> ObtenerTodos();

    Usuario obtenerPorId(Integer id);

    Usuario crearUsuario(Usuario usuario);

    Usuario actualizarUsuario(Integer id, Usuario usuario);

    void eliminarUsuario(Insert id);

}
