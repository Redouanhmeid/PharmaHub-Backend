package com.example.pharma.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.pharma.exception.ResourceNotFoundException;
import com.example.pharma.model.Pharmacie;
import com.example.pharma.repository.PharmacieRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")

public class PharmacieController {
	@Autowired
	private PharmacieRepository pharmacieRepository;
	
	// get all pharmacies
	@GetMapping("/pharmacies")
	public List<Pharmacie> getAllPharmacies(){
		return pharmacieRepository.findAll();	
	}
	
	//create pharmacie Rest Api
	@PostMapping("/pharmacies")
	public Pharmacie createPharmacie(@RequestBody Pharmacie pharmacie) {
		return pharmacieRepository.save(pharmacie);
	}
	
	// get pharmacie by ice
	@GetMapping("/pharmacies/{ICE}")
	public ResponseEntity<Pharmacie> getPharmacieByICE(@PathVariable Long ICE) {
		Pharmacie pharmacie = pharmacieRepository.findById(ICE).orElseThrow(() -> new ResourceNotFoundException("Pharmacie n'existe pas avec ce ICE :"+ ICE));
		return ResponseEntity.ok(pharmacie);
	}
	
	// update pharmacie rest api
	@PutMapping("/pharmacies/{ICE}")
	public ResponseEntity<Pharmacie> updatePharmacie(@PathVariable Long ICE, @RequestBody Pharmacie pharmacieDetails){
		Pharmacie pharmacie = pharmacieRepository.findById(ICE).orElseThrow(() -> new ResourceNotFoundException("Pharmacie n'existe pas avec ce ICE :"+ ICE));
			
		pharmacie.setLibelle(pharmacieDetails.getLibelle());
		pharmacie.setTelephone(pharmacieDetails.getTelephone());
		pharmacie.setEmail(pharmacieDetails.getEmail());
		pharmacie.setAdresse(pharmacieDetails.getAdresse());
		pharmacie.setVille(pharmacieDetails.getVille());
		
		Pharmacie updatedPharmacie = pharmacieRepository.save(pharmacie);
		return ResponseEntity.ok(updatedPharmacie);
	}
	
	// delete pharmacie rest api
	@DeleteMapping("/pharmacies/{ICE}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long ICE){
		Pharmacie pharmacie = pharmacieRepository.findById(ICE)
				.orElseThrow(() -> new ResourceNotFoundException("Pharmacie n'existe pas avec ce ICE :" + ICE));
		
		pharmacieRepository.delete(pharmacie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
