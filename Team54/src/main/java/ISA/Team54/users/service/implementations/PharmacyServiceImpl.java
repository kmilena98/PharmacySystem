package ISA.Team54.users.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ISA.Team54.security.Authority;
import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.mappers.UserMapper;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.model.Supplier;
import ISA.Team54.users.model.SystemAdministrator;
import ISA.Team54.users.repository.DermatologistRepository;
import ISA.Team54.users.repository.PatientRepository;
import ISA.Team54.users.repository.PharmacyAdministratorRepository;
import ISA.Team54.users.repository.SupplierRepository;
import ISA.Team54.users.repository.SystemAdministratorRepository;
import ISA.Team54.users.service.interfaces.AuthorityService;
import ISA.Team54.users.service.interfaces.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PharmacyAdministratorRepository pharmacyAdministratorRepository;
	
	@Autowired
	private SystemAdministratorRepository systemAdministratorRepository;
	
	@Autowired
	private DermatologistRepository dermatologistRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;
	
	@Override
	public Patient addPatient(UserRequestDTO userRequest) {
		Patient patient = UserMapper.UserRequestDTOToPatient(userRequest);	
		patient.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_PATIENT");
		patient.setAuthorities(auth);
		return patientRepository.save(patient);		
	}

	@Override
	public PharmacyAdministrator addPharmacyAdministrator(UserRequestDTO userRequest) {
		PharmacyAdministrator pharmacyAdministrator = UserMapper.UserRequestDTOaToPharmacyAdministrator(userRequest);	
		pharmacyAdministrator.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_ADMIN");
		pharmacyAdministrator.setAuthorities(auth);
		return pharmacyAdministratorRepository.save(pharmacyAdministrator);			
	}
	
	@Override
	public SystemAdministrator addSystemAdministrator(UserRequestDTO userRequest) {
		SystemAdministrator systemAdministrator = UserMapper.UserRequestDTOaToSystemAdministrator(userRequest);	
		systemAdministrator.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_SYSTEM_ADMIN");
		systemAdministrator.setAuthorities(auth);
		return systemAdministratorRepository.save(systemAdministrator);			
	}
	
	@Override
	public Dermatologist addDermatologist(UserRequestDTO userRequest) {
		Dermatologist dermatologist = UserMapper.UserRequestDTOaToDermatologist(userRequest);	
		dermatologist.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_DERMATOLOGIST");
		dermatologist.setAuthorities(auth);
		return dermatologistRepository.save(dermatologist);			
	}
	
	@Override
	public Supplier addSupplier(UserRequestDTO userRequest) {
		Supplier supplier = UserMapper.UserRequestDTOaToSupplier(userRequest);	
		supplier.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_SUPPLIER");
		supplier.setAuthorities(auth);
		return supplierRepository.save(supplier);			
	}
	
}
