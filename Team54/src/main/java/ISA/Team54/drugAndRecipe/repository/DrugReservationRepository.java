package ISA.Team54.drugAndRecipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.drugAndRecipe.enums.ReservationStatus;
import ISA.Team54.drugAndRecipe.model.DrugReservation;

public interface DrugReservationRepository extends JpaRepository<DrugReservation, Long>{
	DrugReservation findOneByIdAndReservedDrugDrugInPharmacyIdPharmaciIdAndStatus( long id,long reservedDrugPharmaciId,ReservationStatus status);   
	DrugReservation findOneById(long id);
}
