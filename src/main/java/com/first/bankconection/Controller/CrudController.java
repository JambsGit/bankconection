/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.Controller;

import com.first.bankconection.service.CrudService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public abstract class CrudController<T, ID> {

    @Autowired
    protected final CrudService<T, ID> crudService;

    @GetMapping
    public ResponseEntity<List<T>> obtenerTodo() {
        return ResponseEntity.ok(crudService.obtenerTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> obtenerPorId(@PathVariable ID id) {
        T entity = crudService.obtenerPorId(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<T> crear(@RequestBody T entity) {
        return ResponseEntity.ok(crudService.crear(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> actualizar(@PathVariable ID id, @RequestBody T entity) {
        T updatedEntity = crudService.actualizar(id, entity);
        return updatedEntity != null ? ResponseEntity.ok(updatedEntity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable ID id) {
        crudService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
