/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CrudService<model, type> {

    List<model> obtenerTodo();  

    model obtenerPorId(type id);  
    
    void insertarInit(); 

    model crear(model entity);  

    model actualizar(type id, model entity); 

    void eliminarPorId(type id); 
}
