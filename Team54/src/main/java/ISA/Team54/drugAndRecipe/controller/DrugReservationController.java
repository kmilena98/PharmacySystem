package ISA.Team54.drugAndRecipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.Examination.dto.ExaminationInformationDTO;
import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.mapper.DrugMapper;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugReservationService;

@RestController
@RequestMapping(value = "/drugReservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class DrugReservationController {
	@Autowired
	private DrugReservationService drugReservationService;
	
	@GetMapping("reservedDrugs/{drugReservationId}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public ResponseEntity<DrugDTO> reservedDrugs(@PathVariable long drugReservationId){
		Drug reservedDrug = drugReservationService.isDrugReservationAvailable(drugReservationId);
		if(reservedDrug==null) {
			return 	new ResponseEntity<DrugDTO>(HttpStatus.BAD_REQUEST);
		}
		return 	new ResponseEntity<DrugDTO>(new DrugMapper().DrugIntoDrugDTO(reservedDrug),HttpStatus.OK);
	}  
	
	@PostMapping("/sellDrug/{reservationId}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public ResponseEntity<String> sellDrug(@PathVariable long reservationId) {
		try { 
		drugReservationService.sellDrug(reservationId);
		}catch(Exception e) {
			return new ResponseEntity<>("Doslo je do greske!", HttpStatus.BAD_REQUEST);
		} 
		return new ResponseEntity<>("Uspjesno sacuvane infomracije o pregledu!", HttpStatus.OK);
	}
}
