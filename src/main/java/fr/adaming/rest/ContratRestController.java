
package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

@RestController
@RequestMapping("/contratWS")
public class ContratRestController {

	@Autowired
	private IContratService contratService;

	/**
	 * @return the contratService
	 */
	public IContratService getContratService() {
		return contratService;
	}

	/**
	 * @param contratService the contratService to set
	 */
	public void setContratService(IContratService contratService) {
		this.contratService = contratService;
	}
	
	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Contrat addContrat(@RequestBody Contrat c){
		return contratService.createContrat(c);
	}
	
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Contrat> getAllContrat(){
		return contratService.getAllContrat();
	}
	
	@RequestMapping(value = "/modif", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Contrat updateContrat(@RequestBody Contrat c) {
		return contratService.updateContrat(c);
	}
	
	@RequestMapping(value = "/supprimer/{pId}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteContrat(@PathVariable("pId") int id) {
		contratService.deleteContrat(id);
	}
	
	@RequestMapping(value = "/contrat/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Contrat getContratById(@PathVariable("pId") int id) {
		return contratService.getContratById(id);
	}
}
