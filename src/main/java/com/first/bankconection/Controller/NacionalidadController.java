/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.model.Nacionalidad;
import com.first.bankconection.service.impl.NacionalidadServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nacionalidades")
public class NacionalidadController extends CrudController<Nacionalidad, String> {

    public NacionalidadController(NacionalidadServiceImpl nacionalidadService) {
        super(nacionalidadService);
    }

}
