/**
 * 
 */
package fr.adaming.rest;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.adaming.model.Bien;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.IBienService;

@RestController
@RequestMapping("/bienWS")

/**
 * @author INTI-0366
 *
 */
public class BienRestController {

	private Bien bien;
	private Conseiller conseiller;
	@Autowired
	private IBienService biService;

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * @return the biService
	 */
	public IBienService getBiService() {
		return biService;
	}

	/**
	 * @param biService
	 *            the biService to set,
	 */
	public void setBiService(IBienService biService) {
		this.biService = biService;
	}

	/**
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller
	 *            the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return the bien
	 */
	public Bien getBien() {
		return bien;
	}

	/**
	 * @param bien
	 *            the bien to set
	 */
	public void setBien(Bien bien) {
		this.bien = bien;
	}

	/**
	 * @return the mailSender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	/**
	 * @param mailSender
	 *            the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@RequestMapping(value = "/Biens", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllProperty() {
		return biService.getAllProperty();
	}

	@RequestMapping(value = "/BiensIDca", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllPropertyByCategory(@RequestParam("pId") int id) {
		return biService.getAllPropertyByCategory(id);
	}

	@RequestMapping(value = "/BiensIDowad", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllPropertyByOwnerAndAdviser(@RequestParam("pIdca") int idp, @RequestParam("pIdco") int idco) {
		return biService.getAllPropertyByOwnerAndAdviser(idp, idco);
	}

	@RequestMapping(value = "/BiensIDcuad", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllPropertyByCustomerAndAdviser(@RequestParam("pIdcl") int idcl,
			@RequestParam("pIdco") int idco) {
		return biService.getAllPropertyByCustomerAndAdviser(idcl, idco);
	}

	@RequestMapping(value = "/Bien", method = RequestMethod.GET, produces = "application/json")
	public Bien getPropertyByID(@RequestParam("pId") int id) {
		return biService.getPropertyByID(id);
	}

	@RequestMapping(value = "/addBien", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Bien createProperty(@RequestBody Bien b) {
		biService.createProperty(b);
		return b;
	}

	@RequestMapping(value = "/updateBien", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Bien updateProperty(@RequestBody Bien b) {
		biService.updateProperty(b);
		return b;
	}

	@RequestMapping(value = "/deleteBien", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteProperty(@RequestParam("pId") int id) {
		biService.deleteProperty(id);
	}

	@RequestMapping(value = "/Biens", method = RequestMethod.POST)
	public String genererMail() {

		// Demande de rendez vous
		String sujet = "Confirmation de votre demande de visite";
		String texte = "Nous accusons bonne réception de votre mail pour la demande de visite du bien : "
				+ this.bien.getAdresse()
				+ ". Nous reviendrons vers vous dés que possible. Merci d'avance. /nCordialement";
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			Session session = Session.getDefaultInstance(props, null);
			FileDataSource source = new FileDataSource("C:\\Users\\INTI-0366\\Desktop\\facture.pdf");

			MimeMessage mail = new MimeMessage(session);
			mail.setFrom(new InternetAddress("martin23121991@gmail.com"));
			mail.setRecipient(Message.RecipientType.TO, new InternetAddress(this.conseiller.getMail()));
			mail.setSubject(sujet);

			BodyPart message = new MimeBodyPart();
			message.setContent(texte, "text/plain");

			BodyPart pieceJointe = new MimeBodyPart();
			pieceJointe.setDataHandler(new DataHandler(source));
			pieceJointe.setFileName("Projer_Agence_Formation_Recapitulatif.pdf");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(message);
			multipart.addBodyPart(pieceJointe);
			mail.setContent(multipart);
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return "accueil";

	}
}