package ISA.Team54.drugAndRecipe.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacyId;

public interface DrugsInPharmacyRepository extends JpaRepository<DrugInPharmacy, DrugInPharmacyId>{
	DrugInPharmacy findOneByDrugInPharmacyId(DrugInPharmacyId id);
}
