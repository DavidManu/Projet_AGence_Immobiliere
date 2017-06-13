/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Visite;

/**
 * @author INTI-0360
 *
 */

@Repository
public class VisiteDaoImpl implements IVisteDao {

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
	 * Methode Ajouter une visite
	 */
	
	@Override
	public Visite createVisite(Visite v) {
		Session s=sf.getCurrentSession();
		s.save(v);
		return v;
	}

	/** 
	 * Methode recuperer la liste des visites
	 */
	
	@Override
	public List<Visite> getAllVisite() {
		Session s=sf.getCurrentSession();
		String req="from Visite";
		Query query=s.createQuery(req);
		return query.list();
	}

	/** 
	 * Methode Modifier une visite
	 */
	
	@Override
	public Visite updateVisite(Visite v) {
		Session s=sf.getCurrentSession();
		Visite visite_rec=(Visite) s.get(Visite.class, v.getId());
		visite_rec=v;
		s.merge(visite_rec);
		return visite_rec;
	}

	/** 
	 * Methode Supprimer une visite
	 */
	@Override
	public void deleteVisite(int id) {
		Session s = sf.getCurrentSession();
		Visite visite_rec=(Visite) s.get(Visite.class, id);
		s.delete(visite_rec);
	}

	/**
	 * Methode rechercher une visite par l'id
	 */
	@Override
	public Visite getVisiteById(int id) {
		Session s = sf.getCurrentSession();
		Visite visite_rec=(Visite) s.get(Visite.class, id);
		return visite_rec;
	}
	
	
}
