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
		System.out.println(entretien.getDate());
		SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd hh:mm:ssa", Locale.US);
	//	java.util.Date t=ft.parse(entretien.getDate());
		ft.applyPattern("MM.dd");
		Es.addEntretien(entretien);
		return entretien;
	}
}
