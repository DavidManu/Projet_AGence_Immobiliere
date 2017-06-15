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

import fr.adaming.dao.IVisteDao;
import fr.adaming.model.Bien;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;
import fr.adaming.model.Visite;

/**
 * @author INTI-0360
 *
 */

@Service
@Transactional
public class VisiteServiceImpl implements IVisteService {

	/**
	 * Injection de dependance
	 */

	@Autowired
	private IVisteDao visiteDao;

	/**
	 * @return the visiteDao
	 */
	public IVisteDao getVisiteDao() {
		return visiteDao;
	}

	/**
	 * @param visiteDao
	 *            the visiteDao to set
	 */
	public void setVisiteDao(IVisteDao visiteDao) {
		this.visiteDao = visiteDao;
	}

	@Override
	public Visite createVisite(Visite v) {
		return visiteDao.createVisite(v);
	}

	@Override
	public List<Visite> getAllVisite() {
		return visiteDao.getAllVisite();
	}

	@Override
	public Visite updateVisite(Visite v) {
		return visiteDao.updateVisite(v);
	}

	@Override
	public void deleteVisite(int id) {
		visiteDao.deleteVisite(id);

	}

	@Override
	public Visite getVisiteById(int id) {
		return visiteDao.getVisiteById(id);
	}

	@Override
	public void createOnePDF(Conseiller c) {
		Document document = new Document();
		List<Proprietaire> listeproprietaires = c.getListeProprietaires();
		List<Client> listeclient = c.getListeClients();

		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\INTI-0366\\Desktop\\facture.pdf"));
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
