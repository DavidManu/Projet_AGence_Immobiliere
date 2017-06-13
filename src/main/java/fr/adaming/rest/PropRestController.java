package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.IPropService;

@RestController
@RequestMapping("/propWS")
public class PropRestController {

	@Autowired
	private IPropService propService;

	public void setPropService(IPropService propService) {
		this.propService = propService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Proprietaire createProprietaire(@RequestBody Proprietaire p) {

		return propService.createProprietaire(p);
	}
	
	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Proprietaire> getAllProprietaire(@RequestParam("pId") int id) {

		return propService.getAllProprietaire(id);
	}

	@RequestMapping(value = "/prop/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Proprietaire getProprietaireById(@PathVariable("pId") int id) {

		return propService.getProprietaireById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Proprietaire updateProprietaire(@RequestBody Proprietaire p) {

		return propService.updateProprietaire(p);
	}

	@RequestMapping(value = "/delete/{pId}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteProprietaire(@PathVariable("pId") int id) {

		propService.deleteProprietaire(id);

	}
}
