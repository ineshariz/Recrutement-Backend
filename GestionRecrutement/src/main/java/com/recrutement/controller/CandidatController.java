package com.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.models.Offre;
import com.recrutement.service.OffreService;


@RestController
@RequestMapping("/candidat")
@CrossOrigin("*")
public class CandidatController {
	@Autowired
	private OffreService offreservice;

	@RequestMapping(method=RequestMethod.GET)
	public List<Offre> getListOffre(){
		return offreservice.getAll();
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Offre addOffre(@RequestBody Offre offre) {
		
		offreservice.add(offre);
		return offre;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Offre find(@PathVariable Integer id) {
		 return offreservice.find(id);
       
    }
	
	/*
	
   @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
   public void delete(@PathVariable Integer id) {
	   poleService.deletePole(id);
       
   }
*/
}
