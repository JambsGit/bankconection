/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.repository;

import com.first.bankconection.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Intraway
 */
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{
}
