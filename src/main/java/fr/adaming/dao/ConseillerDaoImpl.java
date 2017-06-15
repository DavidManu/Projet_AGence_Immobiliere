package fr.adaming.dao;

import java.util.List;

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
	public List<Conseiller> listeConseiller() {
		Session s=sf.openSession();
		String req="from Conseiller";
		Query query=s.createQuery(req);
		return query.list();
	}

}
