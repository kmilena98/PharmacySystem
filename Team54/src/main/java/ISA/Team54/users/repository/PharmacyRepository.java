package ISA.Team54.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.users.model.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
	Pharmacy findById( long id );
}
