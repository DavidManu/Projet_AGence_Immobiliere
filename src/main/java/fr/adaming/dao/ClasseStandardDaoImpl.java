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

import fr.adaming.model.ClasseStandard;

/**
 * Classe d'implementation de l'interface ClasseStandard
 *
 */
@Repository
public class ClasseStandardDaoImpl implements IClasseStandardDao {

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
	 * Methode recuperer la liste des Classes Standard
	 */
	
	@Override
	public List<ClasseStandard> getAllClasseStandard() {
		Session s=sf.getCurrentSession();
		String req="from ClasseStandard";
		Query query=s.createQuery(req);
		return query.list();
	}

	/** 
	 * Methode rechercher classe standard par l'id
	 */
	@Override
	public ClasseStandard getClasseStandardById(int id) {
		Session s = sf.getCurrentSession();
		ClasseStandard cs_rec=(ClasseStandard) s.get(ClasseStandard.class, id);
		return cs_rec;
	}


	@Override
	public void createClasseStandard(ClasseStandard c) {
		Session s=sf.openSession();
		s.save(c);
	}


	@Override
	public void updateClasseStandard(ClasseStandard c) {
		Session s=sf.getCurrentSession();
		ClasseStandard c_rec=(ClasseStandard) s.get(ClasseStandard.class, c.getId());
		c_rec=c;
		s.merge(c_rec);
	}


	@Override
	public void deleteCLasseStandard(int id) {
		Session s=sf.getCurrentSession();
		ClasseStandard c_rec=(ClasseStandard) s.get(ClasseStandard.class, id);
		s.delete(c_rec);
	}

}
