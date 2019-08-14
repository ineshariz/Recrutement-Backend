package com.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.models.Demande;
import com.recrutement.models.Offre;
import com.recrutement.service.PostuleService;

@RestController
@RequestMapping("/demande")
@CrossOrigin("*")
public class PostulerController {
	@Autowired
private PostuleService ps;
	@RequestMapping(method=RequestMethod.GET)
	public List<Demande> getListcandidature(){
		return ps.getAll();
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Demande addOffre(@RequestBody Demande demande) {	
	ps.add(demande);
	return demande;
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public List<Demande>getDemandeParOffres(@PathVariable int id){
		return ps.getDemandeParOffre(id);
	}
	
	@RequestMapping(value="/accepte",method=RequestMethod.PUT)
   	public Demande accepte(@RequestBody Demande demande) {
			demande.setEtat("accepté");
		return ps.add(demande);
   }
	@RequestMapping(value="/refuser",method=RequestMethod.PUT)
   	public Demande refuser(@RequestBody Demande demande) {
			demande.setEtat("refusé");
		return ps.add(demande);
   }
	@RequestMapping(value="/entretien/{id}",method=RequestMethod.GET)
    public Demande find(@PathVariable Integer id) {

		 return ps.find(id);
       
    }
	@RequestMapping(value="/candidat/{id}", method=RequestMethod.GET)
	public List<Demande>getDemandeParCandidat(@PathVariable int id){
		return ps.getDemandeParCandidat(id);
	}
	@RequestMapping(value="/demande/{candidat_id}/{offre_id}", method=RequestMethod.GET)
	public Demande getDemandeParCandidatoffre(@PathVariable int candidat_id,@PathVariable int offre_id ){
		return ps.getDemandeParCandidatoffre(candidat_id,offre_id);
	}
	 
	@RequestMapping(value="/changeEtat",method=RequestMethod.PUT)
   	public Demande changeEtat(@RequestBody Demande demande) {
			demande.setEtat("date de l'entretien choisi");
		return ps.add(demande);
   }

	
	
}
