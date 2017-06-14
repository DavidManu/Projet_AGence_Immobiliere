package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;

@Repository
public class PropDaoImpl implements IPropDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Proprietaire createProprietaire(Proprietaire p) {
		Session s = sf.getCurrentSession();
		s.save(p);
		return p;
	}

	@Override
	public List<Proprietaire> getAllProprietaire(int id) {
		Session s = sf.openSession();
		String getAll = "FROM Proprietaire as p WHERE p.conseiller.id=:pId";
		Query query = s.createQuery(getAll);
		query.setParameter("pId", id);
		return query.list();

	}

	@Override
	public Proprietaire getProprietaireById(int id) {
		Session s = sf.getCurrentSession();
		Proprietaire p = (Proprietaire) s.get(Proprietaire.class, id);
		return p;
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire p) {
		Session s = sf.getCurrentSession();
		Proprietaire p_rec = (Proprietaire) s.get(Proprietaire.class, p.getId());
		p_rec.setNom(p.getNom());
		p_rec.setPrenom(p.getPrenom());
		p_rec.setNumPrive(p.getNumPrive());
		p_rec.setNumTravail(p.getNumTravail());
		p_rec.setListeBiens(p.getListeBiens());
		p_rec.setAdresse(p.getAdresse());
		s.saveOrUpdate(p_rec);
		return p_rec;
	}

	@Override
	public void deleteProprietaire(int id) {
		Session s = sf.openSession();
		Proprietaire p = (Proprietaire) s.get(Proprietaire.class, id);
		s.delete(p);

	}

}
