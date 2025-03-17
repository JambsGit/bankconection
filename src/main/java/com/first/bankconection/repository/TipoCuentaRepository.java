/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.bankconection.repository;

import com.first.bankconection.model.entities.dataInit.TipoCuenta;
import com.first.bankconection.model.enums.TipoCuentaEnum;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Integer>{

    Optional<TipoCuenta> findByNombreTipoCuenta(TipoCuentaEnum tipoCuentaEnum);
    
}
