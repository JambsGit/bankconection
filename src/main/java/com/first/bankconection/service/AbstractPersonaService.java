/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public abstract class AbstractPersonaService<T> {
    
    public abstract List<T> obtenerTodos();
    
    public abstract T obtenerPorId(Integer id);
    
    public abstract T crear(T entity);
    
    public abstract T actualizar(Integer id, T entity);
    
    public abstract void eliminar(Integer id);
}
