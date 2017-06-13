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

import fr.adaming.model.Bien;

@Repository

/**
 * @author INTI-0366
 *
 */
public class BienDaoImpl implements IBienDao {
	
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public List<Bien> getAllProperty() {
		Session s=sf.openSession();
		String req="from Bien";
		Query query=s.createQuery(req);
		return query.list();
	}

	@Override
	public List<Bien> getAllPropertyByAdviser(int id_co) {
		Session s=sf.openSession();
		String req="from Bien as b where b.conseiller.id=:pIdco";
		Query query=s.createQuery(req);
		query.setParameter("pIdco", id_co);
		return query.list();
	}

	@Override
	public List<Bien> getAllPropertyByOwnerAndAdviser(int id_pr, int id_co) {
		Session s=sf.openSession();
		String req="from Bien as b where b.proprietaire.id=:pIdpr and b.conseiller.id=:pIdco";
		Query query=s.createQuery(req);
		query.setParameter("pIdpr", id_pr);
		query.setParameter("pIdco", id_co);
		return query.list();
	}

	@Override
	public List<Bien> getAllPropertyByCustomerAndAdviser(int id_cl, int id_co) {
		Session s=sf.openSession();
		String req="from Bien as b where b.client.id=:pIdcl and b.conseiller.id=:pIdco";
		Query query=s.createQuery(req);
		query.setParameter("pIdcl", id_cl);
		query.setParameter("pIdco", id_co);
		return query.list();
	}

	@Override
	public Bien getPropertyByID(int id_bi) {
		Session s=sf.openSession();
		Bien b=(Bien) s.get(Bien.class, id_bi);
		return b;
	}

	@Override
	public void createProperty(Bien bien) {
		Session s=sf.openSession();
		s.save(bien);
	}

	@Override
	public void updateProperty(Bien bien) {
		Session s=sf.getCurrentSession();
		Bien b_rec=(Bien) s.get(Bien.class, bien.getId());
		b_rec=bien;
		s.merge(b_rec);
	}

	@Override
	public void deleteProperty(int id_bi) {
		Session s=sf.getCurrentSession();
		Bien b_rec=(Bien) s.get(Bien.class, id_bi);
		s.delete(b_rec);
	}

}