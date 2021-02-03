package ISA.Team54.users.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	List<User> findByName(String name);
	List<User> findBySurname(String surname);
	@Query("SELECT u FROM User u WHERE upper(u.name) = ?1 and upper(u.surname) = ?2")
	List<User> findByNameAndSurnameIgnoreCaseIn(String name,String surname);
	@Query("SELECT u FROM User u WHERE upper(u.name) = ?1 or upper(u.surname) = ?2")
	List<User> findByNameOrSurnameIgnoreCaseIn(String name,String surname);
	List<Patient> findAll();
	Optional<Patient> findById(Long id);
	
}
