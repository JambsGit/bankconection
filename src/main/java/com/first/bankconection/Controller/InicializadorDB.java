/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.model.Nacionalidad;
import com.first.bankconection.service.NacionalidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacionalidades")
@ResponseBody
@Controller
public class InicializadorDB {

    @Autowired
    private NacionalidadService nacionalidadService;

    @GetMapping("/inicializar")
    public String inicializarNacionalidades() {
        nacionalidadService.crearNacionalidades();
        return "Nacionalidades inicializadas y clave foránea creada correctamente.";
    }

    @GetMapping("/todas")
    public List<Nacionalidad> mostarNacionalidades() {
        return nacionalidadService.obtenerTodas();
    }

}
