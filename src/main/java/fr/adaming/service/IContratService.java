package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;

/**
 *  Declaration des methodes
 */
public interface IContratService {

	public Contrat createContrat(Contrat c);
	public List<Contrat> getAllContrat();
	public Contrat updateContrat(Contrat c);
	public void deleteContrat(int id);
	public Contrat getContratById(int id);
}
