package com.sis324.Usuarios.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sis324.Usuarios.models.Patient;
import com.sis324.Usuarios.repositories.PatientRespository;

@Service
public class PatientService {

    @Autowired
    PatientRespository patientRepository;

    public ArrayList<Patient> getPatients(){
        return ((ArrayList<Patient>) patientRepository.findAll());
    }

    public Patient save(Patient patient){
        return (patientRepository.save(patient));
    }

    public boolean delete(Long id){
        try {
            patientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

