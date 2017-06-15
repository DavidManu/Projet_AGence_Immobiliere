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

	
}
