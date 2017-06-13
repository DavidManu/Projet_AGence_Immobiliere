/**
 * 
 */
package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Visite;
import fr.adaming.service.IVisteService;

/**
 * @author INTI-0360
 *
 */

@RestController
@RequestMapping("/visiteWS")
public class VisiteRestController {

	@Autowired
	private IVisteService visiteService;

	/**
	 * @param visiteService the visiteService to set
	 */
	public void setVisiteService(IVisteService visiteService) {
		this.visiteService = visiteService;
	}
	
	@RequestMapping(value="/ajout", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Visite addVisite(@RequestBody Visite v){
		return visiteService.createVisite(v);
	}
	
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getAllVisite(){
		return visiteService.getAllVisite();
	}
	
	@RequestMapping(value = "/modif", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Visite updateVisite(@RequestBody Visite v) {
		return visiteService.updateVisite(v);
	}
	
	@RequestMapping(value = "/supprimer/{vId}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteVisite(@PathVariable("vId") int id) {
		visiteService.deleteVisite(id);
	}
	
	@RequestMapping(value = "/visite/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Visite getVisiteById(@PathVariable("vId") int id) {
		return visiteService.getVisiteById(id);
	}
}
