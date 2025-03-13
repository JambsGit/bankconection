/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.Interfaces;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface InterfacePersonaService<Model> {

    Model crear(Model entity);

    Optional<Model> actualizar(Integer id, Model entity);

    Optional<Model> obtenerPorId(Integer id);

    Optional<Boolean> eliminarPorId(Integer id);
}