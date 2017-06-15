/**
 * 
 */
package fr.adaming.service;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import fr.adaming.dao.IBienDao;
import fr.adaming.model.Bien;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;

@Transactional
@Service

/**
 * @author INTI-0366
 *
 */
public class BienServiceImpl implements IBienService {

	@Autowired
	private IBienDao biDAO;

	/**
	 * @return the biDAO
	 */
	public IBienDao getBiDAO() {
		return biDAO;
	}

	/**
	 * @param biDAO
	 *            the biDAO to set
	 */
	public void setBiDAO(IBienDao biDAO) {
		this.biDAO = biDAO;
	}

	@Override
	public List<Bien> getAllProperty() {
		return biDAO.getAllProperty();
	}

	@Override
	public List<Bien> getAllPropertyByCategory(int id_ca) {
		return biDAO.getAllPropertyByCategory(id_ca);
	}

	@Override
	public List<Bien> getAllPropertyByOwnerAndAdviser(int id_pr, int id_co) {
		return biDAO.getAllPropertyByOwnerAndAdviser(id_pr, id_co);
	}

	@Override
	public List<Bien> getAllPropertyByCustomerAndAdviser(int id_pr, int id_cl) {
		return biDAO.getAllPropertyByCustomerAndAdviser(id_pr, id_cl);
	}

	@Override
	public Bien getPropertyByID(int id_bi) {
		return biDAO.getPropertyByID(id_bi);
	}

	@Override
	public void createProperty(Bien bien) {
		biDAO.createProperty(bien);
	}

	@Override
	public void updateProperty(Bien bien) {
		biDAO.updateProperty(bien);
	}

	@Override
	public void deleteProperty(int id_bi) {
		biDAO.deleteProperty(id_bi);
	}

	@Override
	public void createOnePDF(Conseiller c) {
		Document document = new Document();
		List<Proprietaire> listeproprietaires = c.getListeProprietaires();
		List<Client> listeclient = c.getListeClients();

		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\INTI-0366\\Desktop\\Recapitulatif.pdf"));
			document.open();

			PdfPTable tableTitre = new PdfPTable(1);
			PdfPTable tableInfoConseiller = new PdfPTable(1);
			PdfPTable tableInfoClient = new PdfPTable(2);
			PdfPTable tableInfoProp = new PdfPTable(2);
			PdfPTable tableInfoBien = new PdfPTable(2);

			PdfPCell cell1 = new PdfPCell(new Phrase("Recapitulatif Visite Client"));
			tableTitre.addCell(cell1);

			// Informations sur le conseiller
			PdfPCell cell0 = new PdfPCell(new Phrase(" Informations sur le conseiller :"));
			tableInfoConseiller.addCell(" ");
			tableInfoConseiller.addCell("Identifiant :" + c.getIdentifiant());
			tableInfoConseiller.addCell("Mail :" + c.getMail());

			// Informations sur le Bien
			PdfPCell cell2 = new PdfPCell(new Phrase(" Bien concerné par la visite:"));
			tableInfoBien.addCell(cell2);
			tableInfoBien.addCell(" ");

			int i = 0;
			for (Proprietaire p : listeproprietaires) {
				Proprietaire prop = listeproprietaires.get(i);
				Bien bien = prop.getListeBiens().get(i);
				Image image = Image.getInstance(bien.getImage());
				image.scaleAbsolute(image.getScaledHeight() / 10, image.getScaledHeight() / 10);
				tableInfoBien.addCell(image);
				PdfPTable table = new PdfPTable(1);
				table.addCell("Designation - CLasse Standard: " + bien.getType());
				table.addCell("Etat du bien : " + bien.getEtat());
				table.addCell("Superficie du bien : " + bien.getSuperficie());
				table.addCell("Loyer : " + bien.getLoyer());
				table.addCell("Charges : " + bien.getCharges());
				table.addCell("Caution : " + bien.getCaution());
				table.addCell("Date de mise à disposition : " + bien.getDateDispo());
				table.addCell("Adresse : " + bien.getAdresse());
				tableInfoBien.addCell(table);
				i++;
			}

			// Informations sur le proprietaire
			PdfPCell cell3 = new PdfPCell(new Phrase("Informations sur le Proprietaire"));
			tableInfoProp.addCell(cell3);
			tableInfoProp.addCell(" ");
			int j = 0;
			for (Proprietaire p : listeproprietaires) {
				Proprietaire prop = listeproprietaires.get(j);
				PdfPTable table = new PdfPTable(1);
				table.addCell("Nom du Proprietaire: " + prop.getNom());
				table.addCell("Prenom du Proprietaire: " + prop.getPrenom());
				table.addCell("Numéro Personnel du Proprietaire: " + prop.getNumPrive());
				table.addCell("Numéro Privé du Proprietaire: " + prop.getNumTravail());
				table.addCell("Adresse du Proprietaire: " + prop.getAdresse());
				tableInfoProp.addCell(table);
				j++;
			}

			// Informations sur le client
			PdfPCell cell4 = new PdfPCell(new Phrase("Informations sur le Client"));
			tableInfoProp.addCell(cell4);
			tableInfoProp.addCell(" ");

			int k = 0;
			for (Client cl : listeclient) {
				Client client = listeclient.get(k);
				PdfPTable table = new PdfPTable(1);
				table.addCell("Nom du Client: " + client.getNom());
				table.addCell("Prenom du Proprietaire: " + client.getPrenom());
				table.addCell("Numéro Personnel du Proprietaire: " + client.getNumPrive());
				table.addCell("Adresse du Proprietaire: " + client.getAdresse());
				tableInfoProp.addCell(table);
				j++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
	}

}