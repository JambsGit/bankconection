/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.model.Identificacion;
import com.first.bankconection.service.impl.IdentificacionServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/identificaciones")
public class IdentificacionController extends CrudController<Identificacion, String> {

    public IdentificacionController(IdentificacionServiceImpl identificacionService) {
        super(identificacionService);
    }

}
