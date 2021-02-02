package ISA.Team54.users.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ISA.Team54.exceptions.ResourceConflictException;
import ISA.Team54.security.TokenUtils;
import ISA.Team54.security.UserTokenState;
import ISA.Team54.security.auth.JwtAuthenticationRequestDTO;
import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.implementations.CustomUserDetailsService;
import ISA.Team54.users.service.interfaces.PharmacyService;
import ISA.Team54.users.service.interfaces.UserService;


//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PharmacyService pharmacyService;

	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequestDTO authenticationRequest,
			HttpServletResponse response) {

		// 
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserRequestDTO userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(userRequest.getEmail());
		if (existUser != null) {
			throw new ResourceConflictException((long)0, "Username already exists");
		}
		
		User user = null;
		switch(userRequest.getRole()) {
			case PATIENT:
				user = this.pharmacyService.addPatient(userRequest);
			case ADMIN:
				user = this.pharmacyService.addPharmacyAdministrator(userRequest);
			case SYSTEM_ADMIN:
				user = this.pharmacyService.addSystemAdministrator(userRequest);
			case DERMATOLOGIST:
				user = this.pharmacyService.addDermatologist(userRequest);
			case SUPPLIER:
				user = this.pharmacyService.addSupplier(userRequest);
		}
	
	//------------------------
	//Pitanje za ogija,za sta nam treba ovo ispod headers,posto radi isto i sa tim i bez toga		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri()); 
		return new ResponseEntity<>(user, HttpStatus.CREATED); 
	} 


	/* @RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);

		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	} */

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
}
