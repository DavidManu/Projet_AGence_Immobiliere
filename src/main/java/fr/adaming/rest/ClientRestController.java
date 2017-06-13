package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/clientWS")
public class ClientRestController {

	@Autowired
	private IClientService clientService;

	/**
	 * @return the clientService
	 */
	public IClientService getClientService() {
		return clientService;
	}

	/**
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getAllClient(@RequestParam("pId") int id) {
		return clientService.getAllClient(id);
	}

	@RequestMapping(value = "/Client/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Client getOneClient(@PathVariable("pId") int id) {

		return clientService.getClientById(id);
	}

	@RequestMapping(value = "/supprimer/{pId}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteClient(@PathVariable("pId") int id) {

		clientService.deleteClient(id);
	}

	@RequestMapping(value = "/ajout", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Client addClient(@RequestBody Client c) {

		return clientService.createClient(c);

	}

	@RequestMapping(value = "/modif", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Client updateClient(@RequestBody Client c) {

		return clientService.updateClient(c);

	}

}
