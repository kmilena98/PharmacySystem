package ISA.Team54.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.users.model.SystemAdministrator;
import ISA.Team54.users.service.interfaces.SystemAdministratorService;

@RestController
@RequestMapping(value = "/systemAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemAdminsitratorController {
	@Autowired
	private SystemAdministratorService systemAdministratorService;
	
	@GetMapping("/allSystemAdmins")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public  List<SystemAdministrator> findAll(){
		return this.systemAdministratorService.findAll();
	}
}
