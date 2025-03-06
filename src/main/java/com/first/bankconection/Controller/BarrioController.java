/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.model.Barrio;
import com.first.bankconection.service.impl.BarrioServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/barrios")
public class BarrioController extends CrudController<Barrio, Integer> {

    public BarrioController(BarrioServiceImpl barrioService) {
        super(barrioService);
    }

}

