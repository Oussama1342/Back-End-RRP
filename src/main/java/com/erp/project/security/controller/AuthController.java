package com.erp.project.security.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.project.DAO.CaisseRepository;
import com.erp.project.DAO.CoulisRepository;
import com.erp.project.DAO.FactureRepository;
import com.erp.project.entity.Caisse;
import com.erp.project.entity.Coulis;
import com.erp.project.entity.Facture;
import com.erp.project.security.jwt.JwtUtils;
import com.erp.project.security.service.ERole;
import com.erp.project.security.service.Role;
import com.erp.project.security.service.RoleRepository;
import com.erp.project.security.service.User;
import com.erp.project.security.service.UserDetailsImpl;
import com.erp.project.security.service.UserRepository;
import com.erp.project.security.service.payload.JwtResponse;
import com.erp.project.security.service.payload.LoginRequest;
import com.erp.project.security.service.payload.MessageResponse;
import com.erp.project.security.service.payload.SignupRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	CoulisRepository coulisRepository ;
	
	@Autowired
	FactureRepository factureRepo ;
	
	@Autowired
	CaisseRepository caisseRepo ;
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

	

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getBureau(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_CENTRAL)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
		
					Role adminRole = roleRepository.findByName(ERole.ROLE_REGIONAL)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
			
				
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@GetMapping("/bureau/{u}")
	public String findBureau(@PathVariable String u) {
		
		
		return userRepository.findBureau(u);
	}
	
	
	@GetMapping("/findoulis/{bureau}")
	public List<Coulis> findbybureau(@PathVariable String bureau) {
		
		return coulisRepository.findByBureau(bureau) ;
		
	}
	
	
	/************************* Add Couliss *****************/////////
	
	@PostMapping("/addcoulis")
	public Coulis addCoulis(@RequestBody Coulis coulis ) {
		Facture facture = new Facture ();
		Caisse caisse = new Caisse ();
	    

		if(coulis.getModePayement().equalsIgnoreCase("Facture")) {
			facture.setRefFacture(coulis.getRefCoulis());

			facture.setClient(coulis.getNonEmeteur());
			facture.setPriceTTC(coulis.getMontant()) ; 
			factureRepo.save(facture);
		}
		else if(coulis.getModePayement().equalsIgnoreCase("Caisse")) {
			caisse.setRefCaisse(coulis.getRefCoulis());
			caisse.setClient(coulis.getNonEmeteur());
			caisse.setMontant(coulis.getMontant());
			caisseRepo.save(caisse);
		}
		return coulisRepository.save(coulis);
	

	
}
	
	
	////////************ Search 	COolis *******///
	
	@GetMapping("/getcouls/{refscouls}")
	public Coulis getCoulis(@PathVariable String refscouls) {
		
		return coulisRepository.findByRefCoulis(refscouls) ;
	} 

	/////////////////////********  Edit Colis ********************/////////////
	
	@PutMapping("/updatecolis/{idCoulis}")
	public Coulis updateColis(@RequestBody Coulis coulis,@PathVariable int idCoulis){
		
		Coulis colis2 = coulisRepository.findByIdCoulis(idCoulis);
		
		colis2.setRefCoulis(coulis.getRefCoulis()); 
		colis2.setNonEmeteur(coulis.getNonEmeteur());
		colis2.setAddressEmeteur(coulis.getAddressEmeteur());
		colis2.setNumtelEmeteur(coulis.getNumtelEmeteur());
		colis2.setNonRecepteur(coulis.getNonRecepteur());
		colis2.setAddressRecepteur(coulis.getModePayement());
		colis2.setNumtelRecepteur(coulis.getNumtelRecepteur());
	     colis2.setBureau(coulis.getBureau()) ;
		colis2.setRemboursemant(coulis.getRemboursemant());
		colis2.setMontant(coulis.getMontant()) ;
		

		
		//reception2.setMatrCamion(reception.getMatrCamion());
		
		coulisRepository.save(colis2);
		
		return colis2 ;
		
	}
	
	
	////////////////*********** Delete Coulis ****************/////////////
	
	@DeleteMapping("/deletcolis/{idcolis}")
	public void deleteColis(@PathVariable int idcolis) {
		
		Coulis colis = coulisRepository.findByIdCoulis(idcolis) ;
		
		coulisRepository.delete(colis);
	}
	
	
	@GetMapping("/findcolis/{idcolis}")
	public Coulis findolis(@PathVariable int idcolis) {
		
		return coulisRepository.findByIdCoulis(idcolis) ;
		
	}
}
