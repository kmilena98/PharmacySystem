package ISA.Team54.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.service.interfaces.DermatologistService;

@RestController
@RequestMapping(value = "/dermatologist", produces = MediaType.APPLICATION_JSON_VALUE)
public class DermatologistController {
	@Autowired
	private DermatologistService dermatologistService;
	
	@GetMapping("/allDermatologists")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public  List<Dermatologist> findAll(){
		return this.dermatologistService.findAll();
	}
}
