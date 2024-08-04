package org.idtaleb.tp2_orm.presentation;

import org.idtaleb.tp2_orm.dao.Patient;
import org.idtaleb.tp2_orm.metier.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan("org.idtaleb.tp2_orm")
@EntityScan("org.idtaleb.tp2_orm.dao")
@EnableJpaRepositories("org.idtaleb.tp2_orm.dao")
public class PatientPresentation extends SpringBootServletInitializer {

	@Autowired
	PatientService patientService;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(PatientPresentation.class, args);
		PatientPresentation patientPresentation = context.getBean(PatientPresentation.class);
try {
	System.out.println("adding patients");
	patientPresentation.patientService.addPatients(List.of(
			new Patient(null, "nour", new Date(), false, 20),
			new Patient(null, "ahmed", new Date(), true, 50),
			new Patient(null, "houda", new Date(), true, 40),
			new Patient(null, "asmae", new Date(), true, 80),
			new Patient(null, "sarah", new Date(), false, 30)
	));
	System.out.println("-----------------");
	System.out.println("consult all patients");
	patientPresentation.patientService.consultAllPatients().forEach(patient -> {
		System.out.println(patient);
	});
	System.out.println("-----------------");
	System.out.println("consult patient");
	System.out.println(patientPresentation.patientService.consultPatient(4L));
	System.out.println("-----------------");
	System.out.println("update patient");
	System.out.println(patientPresentation.patientService.updatePatient(4L, new Patient(null, "john", new Date(), true, 80)));
	System.out.println("-----------------");
	System.out.println("delete patient");
	patientPresentation.patientService.deletePatient(5L);
	System.out.println("-----------------");
	System.out.println("search patient");
	patientPresentation.patientService.searchPatient(5L);

} catch (Exception ex) {
	System.out.println(ex.getMessage());
}
	}

}
