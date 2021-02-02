package ISA.Team54.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.users.model.PharmacyAdministrator;

public interface PharmacyAdministratorRepository extends JpaRepository<PharmacyAdministrator, Long> {
	PharmacyAdministrator save(PharmacyAdministrator pharmacyAdministrator);
	PharmacyAdministrator findByEmail( String email );

}

