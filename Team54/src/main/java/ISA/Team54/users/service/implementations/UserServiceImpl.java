package ISA.Team54.users.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ISA.Team54.users.model.Patient;
import ISA.Team54.users.repository.UserRepository;
import ISA.Team54.users.service.interfaces.AuthorityService;
import ISA.Team54.users.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;

	@Override
	public Patient findByUsername(String username) throws UsernameNotFoundException {
		Patient u = userRepository.findByEmail(username);
		return u;
	}

	public Patient findById(Long id) throws AccessDeniedException {
		Patient u = userRepository.findById(id).orElseGet(null);
		return u;
	}

	public List<Patient> findAll() throws AccessDeniedException {
		List<Patient> result = userRepository.findAll();
		return result;
	}

/*	@Override
	public User save(UserRequestDTO userRequest) {
		User u = new User();
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
	} */

}
