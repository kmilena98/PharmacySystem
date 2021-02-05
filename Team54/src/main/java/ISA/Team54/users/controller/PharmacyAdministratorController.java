package ISA.Team54.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.model.SystemAdministrator;
import ISA.Team54.users.service.interfaces.PharmacyAdministratorService;
import ISA.Team54.users.service.interfaces.SystemAdministratorService;

@RestController
@RequestMapping(value = "/pharmacyAdministrator", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyAdministratorController {
	@Autowired
	private PharmacyAdministratorService pharmacyAdministratorService;
	
	@GetMapping("/allPharmacyAdmins")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public  List<PharmacyAdministrator> findAll(){
		return this.pharmacyAdministratorService.findAll();
	}
}
