/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UsuarioDTO {
    private String idRegistro;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String idIdentificacion;
    private String numIdentificacion;
    private Date fechaNacimiento;
    private String genero;
    private String idNacionalidad;
    private String calle;
    private Integer idBarrio;
    private String estadoUsuario;
    private Integer idRol;
    private String passwordHash;
}