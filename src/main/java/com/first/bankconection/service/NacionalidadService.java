/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.service;

import com.first.bankconection.model.Nacionalidad;
import java.util.List;
import org.hibernate.sql.Insert;
import org.springframework.stereotype.Service;

/**
 *
 * @author Intraway
 */
@Service
public interface NacionalidadService {

    List<Nacionalidad> obtenerTodas();

    Nacionalidad obtenerPorId(Integer id);

    void crearNacionalidades();
    
    Nacionalidad crearNacionalidad(Nacionalidad nacionalidad);

    Nacionalidad actualizarNacionalidad(Integer id, Nacionalidad nacionalidad);

    void eliminarNacionalidad(Insert id);
}
