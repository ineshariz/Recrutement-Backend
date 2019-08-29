package com.recrutement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.models.ChoixDateEntretien;
import com.recrutement.models.Choixdate;
import com.recrutement.models.Demande;
import com.recrutement.models.Entretien;
import com.recrutement.models.Offre;
import com.recrutement.service.EntretienService;
import com.recrutement.service.OffreService;

@RestController
@RequestMapping("/entretien")
@CrossOrigin("*")
public class EntretienController {
	@Autowired
	private EntretienService Es;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ChoixDateEntretien getdateEntretien(@PathVariable Integer id){
		return Es.get(id);
	}
  
	
	@RequestMapping(value="/choixdate",method=RequestMethod.POST)
	public ChoixDateEntretien addChoixDateEntretien(@RequestBody ChoixDateEntretien choixdate) {
		
		Es.add(choixdate);
		return choixdate;
	}
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Entretien chosirDateEntretien(@RequestBody Entretien entretien) {
		Es.addEntretien(entretien);
		return entretien;
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<ChoixDateEntretien> getListDate(){
		return Es.getAll();
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Entretien> getListEntretien(){
		return Es.getAllEntretien();
	}
	@RequestMapping(value="/effectue",method=RequestMethod.PUT)
   	public Entretien accepte(@RequestBody Entretien entretien) {
		entretien.setEtat("Entretien effectué");
		return Es.addEntretien(entretien);
   }
	
}
