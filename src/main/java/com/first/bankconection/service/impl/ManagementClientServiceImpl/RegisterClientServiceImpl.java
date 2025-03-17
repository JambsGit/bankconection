/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl.ManagementClientServiceImpl;

import com.first.bankconection.model.entities.Cliente;
import com.first.bankconection.model.entities.Cuenta;
import com.first.bankconection.model.entities.Usuario;
import com.first.bankconection.model.entities.dataInit.Rol;
import com.first.bankconection.model.entities.dataInit.TipoCuenta;
import com.first.bankconection.model.enums.EstadoCuentaEnum;
import com.first.bankconection.model.enums.EstadoUsuarioEnum;
import com.first.bankconection.model.enums.TipoClienteEnum;
import com.first.bankconection.model.enums.TipoCuentaEnum;
import com.first.bankconection.model.enums.TipoRolEnum;
import com.first.bankconection.repository.BarrioRepository;
import com.first.bankconection.repository.CuentaRepository;
import com.first.bankconection.repository.IdentificacionRepository;
import com.first.bankconection.repository.NacionalidadRepository;
import com.first.bankconection.repository.RolRepository;
import com.first.bankconection.repository.TipoCuentaRepository;
import com.first.bankconection.repository.UsuarioRepository;
import com.first.bankconection.service.AbstractClases.RegisterUsuarioServiceAbstract;
import com.first.bankconection.service.Interfaces.InterfacePersonaService;
import jakarta.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterClientServiceImpl extends RegisterUsuarioServiceAbstract implements InterfacePersonaService<Usuario> {

    public RegisterClientServiceImpl(
            UsuarioRepository usuarioRepository,
            IdentificacionRepository identificacionRepository,
            NacionalidadRepository nacionalidadRepository,
            BarrioRepository barrioRepository,
            RolRepository rolRepository,
            PasswordEncoder passwordEncoder) {
        super(usuarioRepository, identificacionRepository, nacionalidadRepository, barrioRepository, rolRepository, passwordEncoder);
    }

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    @Override
    @Transactional
    public Usuario crear(Usuario usuario) {
        // 🔹 Check for unique fields
        checkUniqueFields(usuario);

        // 🔹 Assign default role if none is provided
        if (usuario.getRol() == null) {
            Rol defaultRole = rolRepository.findByNombreRol(TipoRolEnum.CLIENTE)
                    .orElseThrow(() -> new RuntimeException("❌ Error: Rol CLIENTE no encontrado en la base de datos."));
            usuario.setRol(defaultRole);
        }

        // 🔹 Validate and set foreign keys
        usuario.setIdentificacion(validateIdentificacion(usuario.getIdentificacion().getIdIdentificacion()));
        usuario.setNacionalidad(validateNacionalidad(usuario.getNacionalidad().getIdNacionalidad()));
        usuario.setBarrio(validateBarrio(usuario.getBarrio().getIdBarrio()));
        usuario.setRol(validateRol(usuario.getRol().getIdRol()));

        // 🔹 Set default values
        usuario.setEstadoUsuario(EstadoUsuarioEnum.INACTIVO); // ✅ Default status: ACTIVO
        usuario.setFechaRegistro(new Date()); // ✅ Set registration date
        usuario.setFechaActualizacion(new Date()); // ✅ Set update date

        // 🔹 Generate and set temporary password
        String tempPassword = generateTemporaryPassword();
        usuario.setPasswordHash(passwordEncoder.encode(tempPassword));

        // 🔹 Log password (For debugging, should be sent via email in production)
        System.out.println("🔹 Temporary password for " + usuario.getCorreo() + " -> " + tempPassword);

        // 🔹 Create client
        Cliente cliente = new Cliente();
        cliente.setVerificado(false);
        cliente.setTipoCliente(TipoClienteEnum.REGULAR);
        copyUserData(cliente, usuario);

        // ✅ Save the new client
        Cliente savedCliente = usuarioRepository.save(cliente);

        // 🔹 Automatically create an account
        crearCuentaParaCliente(savedCliente);

        return savedCliente;
    }

    /**
     * 🔹 Generates a secure random temporary password.
     */
    private String generateTemporaryPassword() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[8]; // Generates a random 8-byte (64-bit) password
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }


    private String generarNumeroCuentaUnico() {
        Random random = new Random();
        String numeroCuenta;

        do {
            numeroCuenta = "CTA-" + (10000000 + random.nextInt(90000000)); // Generate 8-digit random number
        } while (cuentaRepository.existsByNumeroCuenta(numeroCuenta)); // Ensure uniqueness

        return numeroCuenta;
    }

    private void crearCuentaParaCliente(Cliente cliente) {
        // 🔹 Get default account type (AHORRO)
        TipoCuenta tipoCuenta = tipoCuentaRepository.findByNombreTipoCuenta(TipoCuentaEnum.AHORRO)
                .orElseThrow(() -> new RuntimeException("❌ Error: Tipo de cuenta AHORRO no encontrado."));

        // 🔹 Determine account status based on client verification
        EstadoCuentaEnum estadoCuenta = cliente.isVerificado() ? EstadoCuentaEnum.ACTIVO : EstadoCuentaEnum.INACTIVO;

        // 🔹 Create new account
        Cuenta cuenta = new Cuenta(
                cliente,
                tipoCuenta,
                generarNumeroCuentaUnico(),
                0.0, // Default balance
                estadoCuenta // Set account status dynamically
        );

        // ✅ Save the new account
        cuentaRepository.save(cuenta);

        // ✅ Associate the account with the client
        cliente.setCuenta(cuenta);
        usuarioRepository.save(cliente);

        System.out.println("✅ Cuenta creada para cliente: " + cliente.getId()
                + " Número: " + cuenta.getNumeroCuenta()
                + " Estado: " + estadoCuenta);
    }

    @Override
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Usuario> actualizar(Integer id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id).map(existingUser -> {

            // ✅ Ensure `estado_usuario` is never null
            if (usuarioActualizado.getEstadoUsuario() == null) {
                usuarioActualizado.setEstadoUsuario(existingUser.getEstadoUsuario()); // Keep existing state
            }

            // ✅ Ensure `password_hash` is never null
            if (usuarioActualizado.getPasswordHash() == null || usuarioActualizado.getPasswordHash().isEmpty()) {
                usuarioActualizado.setPasswordHash(existingUser.getPasswordHash()); // Keep existing password
            } else {
                // Hash the new password before saving it
                usuarioActualizado.setPasswordHash(passwordEncoder.encode(usuarioActualizado.getPasswordHash()));
            }

            // ✅ Copy updated fields
            copyUserData(existingUser, usuarioActualizado);
            existingUser.setFechaActualizacion(new Date()); // ✅ Update modification date

            return usuarioRepository.save(existingUser);
        });
    }

    @Override
    @Transactional
    public Optional<Boolean> eliminarPorId(Integer id) {
        return usuarioRepository.findById(id).map(user -> {
            usuarioRepository.deleteById(id);
            return true;
        });
    }
}
