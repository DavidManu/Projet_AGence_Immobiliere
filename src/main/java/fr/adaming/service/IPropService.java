package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;

public interface IPropService {

	public Proprietaire createProprietaire(Proprietaire p);

	public List<Proprietaire> getAllProprietaire(int id);

	public Proprietaire getProprietaireById(int id);

	public Proprietaire updateProprietaire(Proprietaire p);

	public void deleteProprietaire(int id);

}
