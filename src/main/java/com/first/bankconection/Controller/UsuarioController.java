/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.dto.UsuarioDTO;
import com.first.bankconection.model.Usuario;
import com.first.bankconection.service.impl.UsuarioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController extends CrudController<Usuario, Integer> {

    private final UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        super(usuarioService);
        this.usuarioService = usuarioService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.ok(nuevoUsuario);
    }
}

