package org.idtaleb.tp2_orm.metier;

import org.idtaleb.tp2_orm.dao.Patient;
import org.idtaleb.tp2_orm.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> addPatients(List<Patient> patients) {
        return patientRepository.saveAll(patients);
    }

    @Override
    public List<Patient> consultAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient consultPatient(Long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw  new RuntimeException("patient not found");
        return patient.get();
    }

    @Override
    public Patient searchPatient(Long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw  new RuntimeException("patient not found");
        return patient.get();
    }

    @Override
    public Patient updatePatient(Long patientId, Patient patient) {
        Patient checkedPatient = searchPatient(patientId);
        checkedPatient.setName(patient.getName());
        checkedPatient.setBirthDate(patient.getBirthDate());
        checkedPatient.setSick(patient.isSick());
        checkedPatient.setScore(patient.getScore());
        return patientRepository.save(checkedPatient);
    }

    @Override
    public void deletePatient(Long patientId) {
        Patient checkedPatient = searchPatient(patientId);
        patientRepository.delete(checkedPatient);
    }
}
