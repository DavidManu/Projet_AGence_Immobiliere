package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Classe d'implementation de l'interface CLient
 */
import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	/**
	 * Declaration de la session
	 */
	private SessionFactory sf;

	/**
	 * @return the sf
	 */
	public SessionFactory getSf() {
		return sf;
	}

	/**
	 * @param sf
	 *            the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * Methode Ajouter un Client
	 */
	@Override
	public Client createClient(Client c) {
		Session s = sf.getCurrentSession();
		s.save(c);
		return c;

	}

	/**
	 * Methode Recuperer la liste des clients
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllCLient() {
		Session s = sf.getCurrentSession();
		String reqGetAll = "From Client";
		Query query = s.createQuery(reqGetAll);
		return query.list();
	}

	/**
	 * Methode Rechercher un client par Id
	 */
	@Override
	public Client getClientById(int id) {
		Session s = sf.getCurrentSession();
		Client client_rec = (Client) s.get(Client.class, id);
		return client_rec;
	}

	
	/**
	 * Methode Modifier un CLient
	 */
	@Override
	public Client updateClient(Client c) {
		Session s = sf.getCurrentSession();
		Client client_rec = (Client) s.get(Client.class, c.getId());
		client_rec.setAdresse(c.getAdresse());
		client_rec.setConseiller(c.getConseiller());
		client_rec.setListeContrats(c.getListeContrats());
		client_rec.setListeVisites(c.getListeVisites());
		client_rec.setNom(c.getNom());
		client_rec.setNumPrive(c.getNumPrive());
		client_rec.setNumTravail(c.getNumTravail());
		client_rec.setPrenom(c.getPrenom());
		client_rec.setTypeDeBien(c.getTypeDeBien());

		s.saveOrUpdate(client_rec);
		return client_rec;

	}

	/**
	 * Methode Supprimer un Client
	 */
	@Override
	public void deleteClient(int id) {
		Session s = sf.getCurrentSession();
		Client client_rec = (Client) s.get(Client.class, id);
		s.delete(client_rec);

	}

}
