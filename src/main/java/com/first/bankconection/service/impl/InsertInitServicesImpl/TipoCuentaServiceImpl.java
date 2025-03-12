/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.InsertInitServicesImpl;

import com.first.bankconection.model.entities.dataInit.TipoCuenta;
import com.first.bankconection.model.enums.TipoCuentaEnum;
import com.first.bankconection.repository.TipoCuentaRepository;
import com.first.bankconection.service.InsertarDatosService;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TipoCuentaServiceImpl extends InsertarDatosService<TipoCuenta, Integer> {

    private final TipoCuentaRepository tipoCuentaRepository;

    @Override
    protected long getEntityCount() {
        return tipoCuentaRepository.count(); // ✅ Check if table is empty
    }

    @Override
    protected List<TipoCuenta> getInitialData() {
        return Arrays.asList(
                new TipoCuenta(null, TipoCuentaEnum.AHORRO),
                new TipoCuenta(null, TipoCuentaEnum.CORRIENTE)
        );
    }

    @Override
    @Transactional
    protected void saveAllEntities(List<TipoCuenta> entities) {
        tipoCuentaRepository.saveAll(entities);
    }
}
