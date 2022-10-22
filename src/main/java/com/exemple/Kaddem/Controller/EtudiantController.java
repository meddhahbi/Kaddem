package com.exemple.Kaddem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.exemple.Kaddem.Entity.Etudiant;
import com.exemple.Kaddem.Entity.Option;
import com.exemple.Kaddem.ServiceInterface.EtudiantServiceInterface;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

	@Autowired
	private EtudiantServiceInterface etudiantService;
	
	
	
<<<<<<< HEAD
	@GetMapping()
=======
	@GetMapping("/")
>>>>>>> ef788409931310c8de58238da47d3ac819c6d657
	public List<Etudiant>etudiants(){
		
		return etudiantService.retrieveAllEtudiants();
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant, Option o){
		
		return ResponseEntity.ok(this.etudiantService.addEtudiant(etudiant, o));
		
		
	}
	
	
	
	
	
	
	
	
	@PutMapping("/update")
	public ResponseEntity<Etudiant>update(@RequestBody Etudiant etudiant){
		
		return ResponseEntity.ok(this.etudiantService.updateEtudiant(etudiant));
	
		
	}
	
	
	@GetMapping("/{id}")
	public Etudiant etudiant (@PathVariable("id") Integer id) {
		
		return this.etudiantService.retrieveEtudiant(id);
		
	}
	
	

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
			
		this.etudiantService.removeEtudiant(id);
		
	}
<<<<<<< HEAD
	@PutMapping("/assign/{etudiantId}/{departementId}")
	public void assignEtudiantToDepartement(@PathVariable Integer etudiantId,@PathVariable Integer departementId){

	this.etudiantService.assignEtudiantToDepartement( etudiantId,  departementId);

	}


=======
	
	
	
>>>>>>> ef788409931310c8de58238da47d3ac819c6d657
}
