package ISA.Team54.users.service.implementations;

import java.util.List;

import ISA.Team54.security.Authority;
import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.service.interfaces.PharmacyService;

public class PharmacyServiceImpl implements PharmacyService {

	@Override
	public void addPatient(UserRequestDTO userRequest) {
		Patient patient = new Patient();
		u.setEmail(userRequest.getUsername());
		// pre nego sto postavimo lozinku u atribut hesiramo je
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		u.setName(userRequest.getFirstname());
		u.setSurname(userRequest.getLastname());
		u.setEnabled(true);
		
		List<Authority> auth = authService.findByname("ROLE_USER");
		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		u.setAuthorities(auth);
		
		u = this.userRepository.save(u);
		return u;
		
	}
	
}
