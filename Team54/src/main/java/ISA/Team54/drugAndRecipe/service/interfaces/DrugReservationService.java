package ISA.Team54.drugAndRecipe.service.interfaces;

import ISA.Team54.drugAndRecipe.model.Drug;

public interface DrugReservationService {
	Drug isDrugReservationAvailable(long reservationId);

	void sellDrug(long reservationId);
}
