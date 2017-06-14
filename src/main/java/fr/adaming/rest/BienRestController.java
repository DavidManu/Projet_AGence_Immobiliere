/**
 * 
 */
package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.adaming.model.Bien;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.IBienService;

@RestController
@RequestMapping("/bienWS")

/**
 * @author INTI-0366
 *
 */
public class BienRestController {
	
	@Autowired
	private IBienService biService;

	/**
	 * @return the biService
	 */
	public IBienService getBiService() {
		return biService;
	}

	/**
	 * @param biService the biService to set,
	 */
	public void setBiService(IBienService biService) {
		this.biService = biService;
	}
	
	@RequestMapping(value="/Biens", method=RequestMethod.GET, produces="application/json")
	public List<Bien> getAllProperty(){
		return biService.getAllProperty();
	}
	
	@RequestMapping(value="/BiensIDad", method=RequestMethod.GET, produces="application/json")
	public List<Bien> getAllPropertyByAdviser(@RequestParam("pId") int id){
		return biService.getAllPropertyByAdviser(id);
	}
	
	@RequestMapping(value="/BiensIDowad", method=RequestMethod.GET, produces="application/json")
	public List<Bien> getAllPropertyByOwnerAndAdviser(@RequestParam("pIdp") int idp, @RequestParam("pIdco") int idco){
		return biService.getAllPropertyByOwnerAndAdviser(idp, idco);
	}
	
	@RequestMapping(value="/BiensIDcuad", method=RequestMethod.GET, produces="application/json")
	public List<Bien> getAllPropertyByCustomerAndAdviser(@RequestParam("pIdcl") int idcl, @RequestParam("pIdco") int idco){
		return biService.getAllPropertyByCustomerAndAdviser(idcl, idco);
	}
	
	@RequestMapping(value="/Bien", method=RequestMethod.GET,  produces="application/json")
	public Bien getPropertyByID(@RequestParam("pId") int id) {
		return biService.getPropertyByID(id);
	}
	
	@RequestMapping(value="/addBien", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Bien createProperty(@RequestBody Bien b) {
		biService.createProperty(b);
		return b;
	}
	
	@RequestMapping(value="/updateBien", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Bien updateProperty(@RequestBody Bien b) {
		biService.updateProperty(b);
		return b;
	}
	
	@RequestMapping(value="/deleteBien", method=RequestMethod.DELETE, produces="application/json")
	public void deleteProperty(@RequestParam("pId") int id){
//		Bien b=biService.getPropertyByID(id);
//		Client cl=new Client();
//		Proprietaire p=new Proprietaire();
//		Conseiller co=new Conseiller();
//		b.setClient(cl);
//		b.setProprietaire(p);
//		b.setConseiller(co);
//		biService.updateProperty(b);
		biService.deleteProperty(id);
	}

}