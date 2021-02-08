package ISA.Team54.drugAndRecipe.service.impl;

import ISA.Team54.drugAndRecipe.enums.ReservationStatus;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacyId;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import ISA.Team54.drugAndRecipe.repository.DrugReservationRepository;
import ISA.Team54.drugAndRecipe.repository.DrugsInPharmacyRepository;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugInPharmacyService;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugReservationService;
import ISA.Team54.exceptions.InvalidTimeLeft;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DrugReservationServiceImpl implements DrugReservationService {

    @Autowired
    private DrugReservationRepository drugReservationRepository;

    @Autowired
    private DrugsInPharmacyRepository drugInPharmacyRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void reserveDrug(DrugInPharmacyId drugInPharmacyId, Date deadline) {
        DrugInPharmacy drugInPharmacy = drugInPharmacyRepository.findOneByDrugInPharmacyId(drugInPharmacyId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());

        DrugReservation reservation = new DrugReservation();
        reservation.setReservedDrug(drugInPharmacy);
        reservation.setReservationToDate(deadline);
        reservation.setPatient(patient);
        reservation.setStatus(ReservationStatus.Reserved);

        drugReservationRepository.save(reservation);
        drugInPharmacy.setQuantity(drugInPharmacy.getQuantity() - 1);
        drugInPharmacyRepository.save(drugInPharmacy);
    }

    @Override
    public List<DrugReservation> getReservationsForPatient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());

        return drugReservationRepository.findAllByPatientId(patient.getId());
    }

    @Override
    public void cancelDrugReservation(long id) throws Exception {
        DrugReservation drugReservation = drugReservationRepository.findById(id).orElse(null);
        if(drugReservation != null){
            if(drugReservation.getReservationToDate().getTime() - new Date().getTime() > 24 * 60 * 60 * 1000){
                drugReservation.setStatus(ReservationStatus.Canceled);
                drugReservationRepository.save(drugReservation);
            }else throw new InvalidTimeLeft();
        }else throw new Exception();
    }
}
