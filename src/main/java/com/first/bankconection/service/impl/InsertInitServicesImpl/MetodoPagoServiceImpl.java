/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.InsertInitServicesImpl;

import com.first.bankconection.model.entities.dataInit.MetodoPago;
import com.first.bankconection.model.enums.TipoMetodoEnum;
import com.first.bankconection.repository.MetodoPagoRepository;
import com.first.bankconection.service.InsertarDatosServiceAbstract;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetodoPagoServiceImpl extends InsertarDatosServiceAbstract<MetodoPago, Integer> {
    
    
    private final MetodoPagoRepository metodoPagoRepository;

    @Override
    protected long getEntityCount() {
        return metodoPagoRepository.count(); // ✅ Check if table is empty
    }

    @Override
        protected List<MetodoPago> getInitialData() {
        return Arrays.asList(
                new MetodoPago(null, TipoMetodoEnum.TARJETA)
        );
    }

    @Override
    @Transactional
    protected void saveAllEntities(List<MetodoPago> entities) {
        metodoPagoRepository.saveAll(entities);
    }
    
}
