package ISA.Team54.drugAndRecipe.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team54.drugAndRecipe.enums.ReservationStatus;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import ISA.Team54.drugAndRecipe.repository.DrugRepository;
import ISA.Team54.drugAndRecipe.repository.DrugReservationRepository;
import ISA.Team54.drugAndRecipe.repository.DrugsInPharmacyRepository;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugReservationService;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.repository.PharmacistRepository;

@Service
public class DrugReservationServiceImpl implements DrugReservationService {
	@Autowired
	private DrugReservationRepository drugReservationRepository;
	@Autowired 
	private DrugRepository drugRepository;
	@Autowired
	private PharmacistRepository pharmacistRepository;
	@Autowired
	private DrugsInPharmacyRepository drugInPharmacyRepository;
	
	private boolean hasExpired(DrugReservation drugReservation) {
		Calendar calendar = Calendar.getInstance();
	    Date today = calendar.getTime();
	    calendar.add(Calendar.DAY_OF_YEAR, 1);
	    Date tomorrow = calendar.getTime();
	    if(drugReservation.getReservationToDate().compareTo(tomorrow)<0)
			return true;
	    return false;
	}
	
	public void sellDrug(long drugReservationId) {
		
		DrugReservation drugReservation = drugReservationRepository.findOneById(drugReservationId);
		DrugInPharmacy drugInPharmacy = drugInPharmacyRepository.findOneByDrugInPharmacyId(drugReservation.getReservedDrug().getDrugInPharmacyId());
		drugInPharmacy.setQuantity(drugInPharmacy.getQuantity()-1);
		drugReservation.setStatus(ReservationStatus.Sold);
		drugReservationRepository.save(drugReservation);
	}
	public Drug isDrugReservationAvailable(long reservationId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Pharmacist pharmacist = pharmacistRepository.findOneById(((Pharmacist) authentication.getPrincipal()).getId());
		DrugReservation drugReservation = drugReservationRepository.findOneByIdAndReservedDrugDrugInPharmacyIdPharmaciIdAndStatus(reservationId,pharmacist.getPharmacy().getId(),ReservationStatus.Reserved);
		if(drugReservation == null) {
			return null;
		}
		if(hasExpired(drugReservation)) {
			return null;
		}
		//sellDrug(drugReservation.getId());
		return drugRepository.findOneById(drugReservation.getReservedDrug().getDrugInPharmacyId().getDrugId());
	}
}
