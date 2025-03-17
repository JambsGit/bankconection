/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.InsertInitServicesImpl;

import com.first.bankconection.model.entities.dataInit.Rol;
import com.first.bankconection.model.enums.TipoRolEnum;
import com.first.bankconection.repository.RolRepository;
import com.first.bankconection.service.AbstractClases.InsertarDatosServiceAbstract;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends InsertarDatosServiceAbstract<Rol, Integer>{

    @Autowired
    private RolRepository rolRepository;
//
//    @Override
//    public Rol crear(Rol entity) {
//        return rolRepository.save(entity);
//    }

//    @Override
//    public Rol actualizar(Integer id, Rol entity) {
//        Rol rolBBDD = rolRepository.findById(id).orElse(null);
//        if (rolBBDD != null) {
//            rolBBDD.setNombreRol(entity.getNombreRol());
//            rolRepository.save(rolBBDD);
//        }
//
//        return rolBBDD;
//    }
//
//    @Override
//    public List<Rol> obtenerTodo() {
//        return rolRepository.findAll();
//    }
//
//    @Override
//    public Rol obtenerPorId(Integer id) {
//        return rolRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void eliminarPorId(Integer id) {
//        rolRepository.deleteById(id);
//    }

    @Override
    protected List<Rol> getInitialData() {
        return Arrays.asList(
                new Rol(2, TipoRolEnum.CLIENTE),
                new Rol(1, TipoRolEnum.ADMINISTRADOR)
        );
    }

    @Override
    protected long getEntityCount() {
        return rolRepository.count();  // ✅ Check if data exists
    }
    
    @Override
    protected void saveAllEntities(List<Rol> entities) {
        rolRepository.saveAll(entities);
    }
    
}
