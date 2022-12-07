package com.exemple.Kaddem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.exemple.Kaddem.Repositories.EtudiantRepository;
import com.exemple.Kaddem.Repositories.UserRepository;
import com.exemple.Kaddem.ServiceInterface.EtudiantServiceInterface;

import javax.transaction.Transactional;

@RestController
@CrossOrigin("*")
@RequestMapping("/etudiant")
public class EtudiantController extends BaseController<Etudiant, Integer>{

	@Autowired
	private EtudiantServiceInterface etudiantService;
	
	@Autowired
	private EtudiantRepository etudiantRepository;

	
	
	   @PostMapping("Assigne/{idE}/{idD}")
	    private Etudiant AddandAssigne(@PathVariable(value = "idE") Integer idE,@PathVariable(value = "idD") Integer idD){
	        etudiantService.assignEtudiantToDepartement(idE,idD);
	        return etudiantService.retrieve(idE) ;
	    }
	    @GetMapping("list/{idD}")
	    private List<Etudiant> getEtudiantsByDepartement(@PathVariable(value = "idD") Integer idD){
	        return etudiantService.getEtudiantsByDepartement(idD);
	    }


	@PostMapping("add_etudiant/assign_equipe/{idE}")
	@Transactional
	Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant etudiant, @PathVariable(value = "idE") Integer idEquipe){
		return etudiantService.addAndAssignEtudiantToEquipe(etudiant, idEquipe);
	}

		@PutMapping("/assign_equipe/{idEt}/{idEq}")
//		@Transactional
		void assignEtudiantToEquipe(@PathVariable(value = "idEt") Integer idEtudiant, @PathVariable(value = "idEq") Integer idEquipe){
		    etudiantService.assignEtudiantToEquipe(idEtudiant, idEquipe);
		}


	    
	    @GetMapping("/count")
		private Integer getNumberOfEtudiant(){
		    return (int) etudiantRepository.count();
		}
		
	    

	
}
