/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.service.impl.InsertInitServices.BarrioServiceImpl;
import com.first.bankconection.service.impl.InsertInitServices.IdentificacionServiceImpl;
import com.first.bankconection.service.impl.InsertInitServices.MetodoPagoServiceImpl;
import com.first.bankconection.service.impl.InsertInitServices.NacionalidadServiceImpl;
import com.first.bankconection.service.impl.InsertInitServices.RolServiceImpl;
import com.first.bankconection.service.impl.InsertInitServices.TipoCuentaServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping
@RestController
public class InicializadorDB {

    private final IdentificacionServiceImpl identificacionService;
    private final NacionalidadServiceImpl nacionalidadService;
    private final BarrioServiceImpl barrioService;
    private final RolServiceImpl rolService;
    private final TipoCuentaServiceImpl insertarTipoCuentaService;
    private final MetodoPagoServiceImpl metodoPagoServiceImpl;

    @PostConstruct
    public void iniciarBaseDeDatos() {
        identificacionService.insertarInit();
        nacionalidadService.insertarInit();
        barrioService.insertarInit();
        rolService.insertarInit();
        insertarTipoCuentaService.insertarInit();
        metodoPagoServiceImpl.insertarInit();

    }

}
