package com.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.models.Offre;
import com.recrutement.service.OffreService;


@RestController
@RequestMapping("/emploi")
@CrossOrigin("*")
public class EmploiController {
	@Autowired
	private OffreService offreservice;

	@RequestMapping(value="/disponible",method=RequestMethod.GET)
	public List<Offre> getListOffreDisponible(){
		return offreservice.getAllFiltred();
	}
	
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

	@RequestMapping(value="/",method=RequestMethod.PUT)
   	public Offre update(@RequestBody Offre offre) {
		return offreservice.edit(offre);
   }
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
   	public ResponseEntity<?> delete(@PathVariable Integer id) {
		 offreservice.delete(id);
		 return ResponseEntity.ok("deleted");
   }
	/*
	@RequestMapping(value="/update",method=RequestMethod.PUT)
   	public Pole update(@RequestBody Pole pole) {
		return poleService.addPole(pole);
   }
	
	@RequestMapping(value="/disable",method=RequestMethod.PUT)
   	public Pole disable(@RequestBody Pole pole) {
		if(pole.getEtat()==true)
			pole.setEtat(false);
		else
			pole.setEtat(true);
		return poleService.addPole(pole);
   }
	
   @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
   public void delete(@PathVariable Integer id) {
	   poleService.deletePole(id);
       
   }
*/
}
