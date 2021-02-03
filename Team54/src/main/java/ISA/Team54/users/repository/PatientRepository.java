package ISA.Team54.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ISA.Team54.users.dto.BasicPatientInfoDTO;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	List<User> findByName(String name);
	List<User> findBySurname(String surname);
	Patient findById(long id);
	
	/*@Modifying
	@Query("update patient set "
			+ "name = ?1, "
			+ "surname = ?2, "
			+ "address = ?3, "
			+ "city = ?4, "
			+ "country = ?5 ,"
			+ "phoneNumber = ?6"
			+ " where id = ?7")
	void updatePatient(String name, String surname, String address, String city, String country, String phone, Long id);*/
}
