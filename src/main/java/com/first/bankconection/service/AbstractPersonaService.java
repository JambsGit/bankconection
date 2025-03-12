/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service;

import org.springframework.stereotype.Service;

@Service
public interface AbstractPersonaService<Model> {

    Model crear(Model entity);

    Model actualizar(Integer id, Model entity);

    void eliminar(Integer id);
}
