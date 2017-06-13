
package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Contrat;

/**
 *  Classe d'implémentation de l'interface Contrat
 */

@Repository
public class ContratDaoImpl implements IContratDao {

	/** 
	 * Declaration de la session
	 */
	@Autowired
	private SessionFactory sf;
		
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * Methode Ajouter un Contrat
	 */
	@Override
	public Contrat createContrat(Contrat c) {
		Session s=sf.getCurrentSession();
		s.save(c);
		return c;
	}

	/** 
	 * Methode recuperer la liste des contrats
	 */
	@Override
	public List<Contrat> getAllContrat() {
		Session s=sf.getCurrentSession();
		String req="from Contrat";
		Query query=s.createQuery(req);
		return query.list();
	}

	/** 
	 * Methode Modifier un Contrat
	 */
	@Override
	public Contrat updateContrat(Contrat c) {
		Session s=sf.getCurrentSession();
		Contrat contrat_rec=(Contrat) s.get(Contrat.class, c.getId());
		contrat_rec=c;
		s.merge(contrat_rec);
		return contrat_rec;
	}

	/** 
	 * Methode Supprimer un Contrat
	 */
	@Override
	public void deleteContrat(int id) {
		Session s = sf.getCurrentSession();
		Contrat contrat_rec = (Contrat) s.get(Contrat.class, id);
		s.delete(contrat_rec);

	}

	/**
	 * Methode rechercher un contrat par l'id
	 */
	@Override
	public Contrat getContratById(int id) {
		Session s = sf.getCurrentSession();
		Contrat contrat_rec= (Contrat) s.get(Contrat.class, id);
		return contrat_rec;
	}

}
