/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl;

import com.first.bankconection.model.Nacionalidad;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.service.NacionalidadService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class InsertarNacionalidadesServiceImpl implements NacionalidadService{

    @Autowired
    private NacionalidadRepository nacionalidadRepository;
    
    @Override
    public void crearNacionalidades() {
        List<Nacionalidad> nacionalidades = Arrays.asList(
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

        // Guardar todas las nacionalidades en la base de datos
        nacionalidadRepository.saveAll(nacionalidades);
       
        
    }

    @Override
    public Nacionalidad crearNacionalidad(Nacionalidad nacionalidad) {
        return nacionalidadRepository.save(nacionalidad);
    }

}
