/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.bankconection.service.impl;

import com.first.bankconection.service.CrudService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public abstract class InsertarDatosServiceImpl<T, ID> implements CrudService<T, ID> {
    
// Abstract method for getting repository count
    protected abstract long getEntityCount();

    // Abstract method for getting initial data
    protected abstract List<T> getInitialData();

    protected abstract void saveAllEntities(List<T> entities);

    @Override
    public void insertarInit() {
        if (getEntityCount() == 0) {  // ✅ Only insert if table is empty
            List<T> initialData = getInitialData();
            if (!initialData.isEmpty()) {
                saveAllEntities(initialData);
                System.out.println("✅ Initial data inserted: " + initialData.size() + " records");
            } else {
                System.out.println("⚠ No initial data found to insert.");
            }
        } else {
            System.out.println("⏭ Data already exists. Skipping initialization.");
        }
    }
}


