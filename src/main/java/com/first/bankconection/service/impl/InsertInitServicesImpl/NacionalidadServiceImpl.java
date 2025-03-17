/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.service.impl.InsertInitServicesImpl;

import com.first.bankconection.model.entities.dataInit.Nacionalidad;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.service.AbstractClases.InsertarDatosServiceAbstract;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NacionalidadServiceImpl extends InsertarDatosServiceAbstract<Nacionalidad, String> {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;
//
//    @Override
//    public Nacionalidad crear(Nacionalidad entity) {
//        return nacionalidadRepository.save(entity);
//    }

//    @Override
//    public Nacionalidad actualizar(String id, Nacionalidad entity) {
//        Nacionalidad nacionalidadBBDD = nacionalidadRepository.findById(id).orElse(null);
//        if (nacionalidadBBDD != null) {
//            nacionalidadBBDD.setNombreNacionalidad(entity.getNombreNacionalidad());
//            nacionalidadRepository.save(nacionalidadBBDD);
//        }
//
//        return nacionalidadBBDD;
//    }
//
//    @Override
//    public List<Nacionalidad> obtenerTodo() {
//        return nacionalidadRepository.findAll();
//    }
//
//    @Override
//    public Nacionalidad obtenerPorId(String id) {
//        return nacionalidadRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void eliminarPorId(String id) {
//        nacionalidadRepository.deleteById(id);
//    }

    @Override
    protected List<Nacionalidad> getInitialData() {
        return List.of(
                new Nacionalidad("ES", "España"),
                new Nacionalidad("MX", "México"),
                new Nacionalidad("GT", "Guatemala"),
                new Nacionalidad("SV", "El Salvador"),
                new Nacionalidad("HN", "Honduras"),
                new Nacionalidad("NI", "Nicaragua"),
                new Nacionalidad("CR", "Costa Rica"),
                new Nacionalidad("PA", "Panamá"),
                new Nacionalidad("CU", "Cuba"),
                new Nacionalidad("DO", "República Dominicana"),
                new Nacionalidad("PR", "Puerto Rico"),
                new Nacionalidad("CO", "Colombia"),
                new Nacionalidad("VE", "Venezuela"),
                new Nacionalidad("EC", "Ecuador"),
                new Nacionalidad("PE", "Perú"),
                new Nacionalidad("BO", "Bolivia"),
                new Nacionalidad("PY", "Paraguay"),
                new Nacionalidad("CL", "Chile"),
                new Nacionalidad("AR", "Argentina"),
                new Nacionalidad("UY", "Uruguay"),
                new Nacionalidad("GQ", "Guinea Ecuatorial")
        );
    }

    @Override
    protected long getEntityCount() {
        return nacionalidadRepository.count();  // ✅ Check if data exists
    }

    @Override
    protected void saveAllEntities(List<Nacionalidad> entities) {
        nacionalidadRepository.saveAll(entities);
    }
}
