package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Conseiller;
import fr.adaming.service.IConseillerService;

@RestController
public class ConseillerRestController {
	
	@Autowired
	private IConseillerService conseillerService;

	public IConseillerService getConseillerService() {
		return conseillerService;
	}

	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}
	
	@RequestMapping(value = "/conseiller", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public Conseiller seConnecter (@RequestBody Conseiller conseiller){
		return conseillerService.isExist(conseiller);
	};
	
	
}
