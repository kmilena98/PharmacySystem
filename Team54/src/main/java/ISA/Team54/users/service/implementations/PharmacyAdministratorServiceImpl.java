package ISA.Team54.users.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.repository.PharmacyAdministratorRepository;
import ISA.Team54.users.service.interfaces.PharmacyAdministratorService;


public class PharmacyAdministratorServiceImpl implements PharmacyAdministratorService {
	
	@Autowired
	PharmacyAdministratorRepository PharmacyAdministratorRepository;
	
	@Override
	public List<PharmacyAdministrator> findAll() {
		return this.PharmacyAdministratorRepository.findAll();
	}
}

