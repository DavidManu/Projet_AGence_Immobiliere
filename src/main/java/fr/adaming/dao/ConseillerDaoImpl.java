package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Conseiller;

@Repository
public class ConseillerDaoImpl implements IConseillerDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Conseiller isExist(Conseiller conseiller) {
		Session s = sf.getCurrentSession();
		String req = "FROM Conseiller conseiller WHERE conseiller.mail=:pmail and conseiller.mdp=:pmdp";
		Query query = s.createQuery(req);
		query.setParameter("pmail", conseiller.getMail());
		query.setParameter("pmdp", conseiller.getMdp());

		Conseiller conseiller_rec = (Conseiller) query.uniqueResult();

		return conseiller_rec;

	}

}
