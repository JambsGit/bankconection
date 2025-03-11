/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl;

import com.first.bankconection.model.entities.dataInit.Identificacion;
import com.first.bankconection.repository.IdentificacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentificacionServiceImpl extends InsertarDatosServiceImpl<Identificacion, String> {

    @Autowired
    private IdentificacionRepository identificacionRepository;

    @Override
    public Identificacion crear(Identificacion entity) {
        return identificacionRepository.save(entity);
    }

    @Override
    public Identificacion actualizar(String id, Identificacion entity) {
        Identificacion identificacionBBDD = identificacionRepository.findById(id).orElse(null);
        if (identificacionBBDD != null) {
            identificacionBBDD.setTipoIdentificacion(entity.getTipoIdentificacion());
            identificacionRepository.save(identificacionBBDD);
        }

        return identificacionBBDD;
    }

    @Override
    public List<Identificacion> obtenerTodo() {
        return identificacionRepository.findAll();
    }

    @Override
    public Identificacion obtenerPorId(String id) {
        return identificacionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPorId(String id) {
        identificacionRepository.deleteById(id);
    }

    @Override
    protected List<Identificacion> getInitialData() {
        return List.of(
                new Identificacion("CC", "Cédula de Ciudadanía"),
                new Identificacion("TI", "Tarjeta de Identidad"),
                new Identificacion("CE", "Cédula de Extranjería"),
                new Identificacion("NIT", "Número de Identificación Tributaria")
        );
    }

    @Override
    protected long getEntityCount() {
        return identificacionRepository.count();  // ✅ Check if data exists
    }

    @Override
    protected void saveAllEntities(List<Identificacion> entities) {
        identificacionRepository.saveAll(entities);
    }

}
