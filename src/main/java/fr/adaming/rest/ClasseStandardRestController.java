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

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IClasseStandardService;

/**
 * @author INTI-0360
 *
 */

@RestController
@RequestMapping("/ClasseStandardWS")
public class ClasseStandardRestController {

	@Autowired
	private IClasseStandardService csService;

	/**
	 * @param csService the csService to set
	 */
	public void setCsService(IClasseStandardService csService) {
		this.csService = csService;
	}
	
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<ClasseStandard> getAllClasseStandard(){
		return csService.getAllClasseStandard();
	}
		
	@RequestMapping(value = "/classestandard/{csId}", method = RequestMethod.GET, produces = "application/json")
	public ClasseStandard getClasseStandardById(@PathVariable("csId") int id) {
		return csService.getClasseStandardById(id);
	}
}
