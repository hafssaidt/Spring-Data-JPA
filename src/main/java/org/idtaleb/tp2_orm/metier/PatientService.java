package org.idtaleb.tp2_orm.metier;

import org.idtaleb.tp2_orm.dao.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> addPatients(List<Patient> patients);

    List<Patient> consultAllPatients();

    Patient consultPatient(Long patientId);

    Patient searchPatient(Long patientId);

    Patient updatePatient(Long patientId, Patient patient);

    void deletePatient(Long patientId);

}