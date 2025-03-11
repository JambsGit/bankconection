/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.model.interfaces;

/**
 *
 * @author Intraway
 */
public interface Autenticable {
    boolean autenticar(String credencial);
    void actualizarUltimaAutenticacion();
}
