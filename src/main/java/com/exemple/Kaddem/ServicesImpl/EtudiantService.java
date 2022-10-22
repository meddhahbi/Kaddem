package com.exemple.Kaddem.ServicesImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

<<<<<<< HEAD
import com.exemple.Kaddem.Repositories.DepartementRepositories;
import lombok.AllArgsConstructor;
=======
>>>>>>> ef788409931310c8de58238da47d3ac819c6d657
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.Kaddem.Entity.Departement;
import com.exemple.Kaddem.Entity.Etudiant;
import com.exemple.Kaddem.Entity.Option;
import com.exemple.Kaddem.Repositories.EtudiantRepository;
import com.exemple.Kaddem.ServiceInterface.EtudiantServiceInterface;


@Service
<<<<<<< HEAD
@AllArgsConstructor
public class EtudiantService implements EtudiantServiceInterface{

	

	private EtudiantRepository etudiantRepo;

	private DepartementRepositories departementRepositories;
=======
public class EtudiantService implements EtudiantServiceInterface{

	
	@Autowired
	private EtudiantRepository etudiantRepo;
	
>>>>>>> ef788409931310c8de58238da47d3ac819c6d657
	
	@Override
	public List<Etudiant> retrieveAllEtudiants() {
		
		return new ArrayList<>(this.etudiantRepo.findAll());
	}

	@Override
	public Etudiant addEtudiant(Etudiant e, Option o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant addAndAssignEtudiant(Etudiant e, Option o, Departement d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		
		return this.etudiantRepo.save(e);
	}

	@Override
	public Etudiant retrieveEtudiant(Integer idEtudiant) {
		
		return this.etudiantRepo.findById(idEtudiant).get();
	}

	@Override
	public void removeEtudiant(Integer idEtudiant) {
		this.etudiantRepo.deleteById(idEtudiant);
		
	}

<<<<<<< HEAD
	@Override
	public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
		/*recuperation des objet*/
		Etudiant etudiant = etudiantRepo.findById(etudiantId).orElse(null);
		Departement  departement = departementRepositories.findById(departementId).orElse(null);
		/*verification*/
		if (etudiant!=null && departement!=null){
			/*treatement*/
			etudiant.setDepartement(departement);
			/*save*/
			etudiantRepo.save(etudiant);
		}
	}

=======
>>>>>>> ef788409931310c8de58238da47d3ac819c6d657
}
