package com.exemple.Kaddem.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.Kaddem.Entity.JwtRequest;
import com.exemple.Kaddem.Entity.JwtResponse;
import com.exemple.Kaddem.Helpers.UserNotFoundException;
import com.exemple.Kaddem.ServicesImpl.UserDetailsServiceImp;
import com.exemple.Kaddem.config.JwtUtils;
import com.exemple.Kaddem.Entity.Users;


@RestController
@CrossOrigin("*")
public class AuthenticateController {

	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsServiceImp userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	
	

	@PostMapping("/generate-token")
	public ResponseEntity<?>generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		
		try {
			
			
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		}catch(UserNotFoundException e) {
			
			e.printStackTrace();
			throw new Exception("User not found");
			
		}
		
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token  = this.jwtUtils.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	
	
	
	
	
	
	
	private void authenticate(String username, String password) throws Exception {
		
		
		try {
		
		authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		}catch(DisabledException e){
			
			
			throw new Exception ("User Disabled" + e.getMessage());
			
		}catch(BadCredentialsException e) {
			
			throw new Exception("Invalid Credential" + e.getMessage());
			
		}
	}
	
	@GetMapping("/current-user")
	public Users getCurrentUser(Principal principal) {
		
		return ((Users)this.userDetailsService.loadUserByUsername(principal.getName()));
		
		
		
	}
	
	
	
	
}
