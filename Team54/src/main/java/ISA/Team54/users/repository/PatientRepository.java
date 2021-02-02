package ISA.Team54.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.users.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {
	Patient save(Patient patient);
	Patient findByEmail( String email );

}
