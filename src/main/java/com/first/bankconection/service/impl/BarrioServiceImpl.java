/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl;

import com.first.bankconection.model.Barrio;
import com.first.bankconection.repository.BarrioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarrioServiceImpl extends InsertarDatosServiceImpl<Barrio, Integer> {

    @Autowired
    private BarrioRepository barrioRepository;

    @Override
    public Barrio crear(Barrio entity) {
        return barrioRepository.save(entity);
    }

    @Override
    public Barrio actualizar(Integer id, Barrio entity) {
        Barrio barrioBBDD = barrioRepository.findById(id).orElse(null);
        if (barrioBBDD != null) {
            barrioBBDD.setNombreBarrio(entity.getNombreBarrio());
            barrioRepository.save(barrioBBDD);
        }

        return barrioBBDD;
    }

    @Override
    public List<Barrio> obtenerTodo() {
        return barrioRepository.findAll();
    }

    @Override
    public Barrio obtenerPorId(Integer id) {
        return barrioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPorId(Integer id) {
        barrioRepository.deleteById(id);
    }

    @Override
    protected List<Barrio> getInitialData() {
        return List.of(
                new Barrio("Chapinero"),
                new Barrio("Teusaquillo"),
                new Barrio("Suba"),
                new Barrio("Usaquén"),
                new Barrio("Fontibón"),
                new Barrio("Engativá"),
                new Barrio("Kennedy"),
                new Barrio("Bosa"),
                new Barrio("Ciudad Bolívar"),
                new Barrio("San Cristóbal"),
                new Barrio("Usme"),
                new Barrio("Tunjuelito"),
                new Barrio("Antonio Nariño"),
                new Barrio("Santa Fe"),
                new Barrio("Candelaria"),
                new Barrio("Barrios Unidos"),
                new Barrio("Puente Aranda"),
                new Barrio("Rafael Uribe Uribe"),
                new Barrio("Sumapaz"),
                new Barrio("Los Mártires")
        );
    }

    @Override
    protected long getEntityCount() {
        return barrioRepository.count();  // ✅ Check if data exists
    }

    @Override
    protected void saveAllEntities(List<Barrio> entities) {
        barrioRepository.saveAll(entities);
    }
}
