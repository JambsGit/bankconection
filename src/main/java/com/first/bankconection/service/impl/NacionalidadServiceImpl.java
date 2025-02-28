/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.service.impl;

import com.first.bankconection.model.Nacionalidad;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.service.NacionalidadService;
import java.util.List;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NacionalidadServiceImpl extends InsertarNacionalidadesServiceImpl implements NacionalidadService {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    //otros metodos
    @Override
    public Nacionalidad actualizarNacionalidad(Integer id, Nacionalidad nacionalidad) {
        return null;
    }

    @Override
    public List<Nacionalidad> obtenerTodas() {
        return nacionalidadRepository.findAll();
    }

    @Override
    public Nacionalidad obtenerPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminarNacionalidad(Insert id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
