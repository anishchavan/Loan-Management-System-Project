package com.lms.customerservice.app.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.model.SanctionLetter;
import com.lms.customerservice.app.repository.CustomerRepository;
import com.lms.customerservice.app.repository.SanctionRepository;
import com.lms.customerservice.app.servicei.SanctionServiceI;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class SanctionServiceImpl implements SanctionServiceI{
	
	@Autowired
	CustomerRepository cr;

	@Autowired
	SanctionRepository sr;

	@Override
	public CustomerDetails generateSactionId(int customerId, SanctionLetter sanctionLetter) {
		Optional<CustomerDetails> customerdetails = cr.findById(customerId);
		CustomerDetails customerdetails1 = customerdetails.get();
		if(customerdetails.isPresent()) {
			customerdetails1.getSanctionLetter().setSanctionDate(sanctionLetter.getSanctionDate());
			customerdetails1.getSanctionLetter().setApplicantName(customerdetails.get().getCustomerFirstName());
			customerdetails1.getSanctionLetter().setLoanAmountSanctioned(sanctionLetter.getLoanAmountSanctioned());
			customerdetails1.getSanctionLetter().setRateOfInterest(sanctionLetter.getRateOfInterest());
			customerdetails1.getSanctionLetter().setLoanTenure(sanctionLetter.getLoanTenure());
			customerdetails1.getSanctionLetter().setMonthlyEmiAmount(sanctionLetter.getMonthlyEmiAmount());
		
			String title = "LMS BANK Ltd.";

			Document document = new Document(PageSize.A4);

			String content1 = "\n\n Dear " + customerdetails1.getCustomerFirstName()
					+ ","
					+ "\nLMS BANK Ltd. is Happy to informed you that your loan application has been approved. ";

			String content2 = "\n\nWe hope that you find the terms and conditions of this loan satisfactory "
					+ "and that it will help you meet your financial needs.\n\nIf you have any questions or need any assistance regarding your loan, "
					+ "please do not hesitate to contact us.\n\nWe wish you all the best and thank you for choosing us."
					+ "\n\nSincerely,\n\n" + "Anish Chavan (Credit Manager)";

			ByteArrayOutputStream opt = new ByteArrayOutputStream();
			
			PdfWriter.getInstance(document, opt);
			document.open();

			Image img = null;
			try {
				img = Image.getInstance("C:\\Users\\ACER\\Downloads\\lmslogo.png");
				img.scalePercent(50, 50);
				img.setAlignment(Element.ALIGN_RIGHT);
				document.add(img);

			} catch (BadElementException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
			Paragraph titlepara = new Paragraph(title, titlefont);
			titlepara.setAlignment(Element.ALIGN_CENTER);
			document.add(titlepara);

			Font titlefont2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			Paragraph paracontent1 = new Paragraph(content1, titlefont2);
			document.add(paracontent1);

			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100f);
			table.setWidths(new int[] { 2, 2 });
			table.setSpacingBefore(10);

			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(CMYKColor.WHITE);
			cell.setPadding(5);

			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font.setColor(5, 5, 161);

			Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
			font.setColor(5, 5, 161);

			cell.setPhrase(new Phrase("Loan amount Sanctioned", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf("₹ " + customerdetails1.getSanctionLetter().getLoanAmountSanctioned()),
					font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("loan tenure", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(customerdetails1.getSanctionLetter().getLoanTenure()), font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("interest rate", font));
			table.addCell(cell);

			cell.setPhrase(
					new Phrase(String.valueOf(customerdetails1.getSanctionLetter().getRateOfInterest()) + " %", font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Sanction letter generated Date", font));
			table.addCell(cell);

			Date date = new Date();
			String curdate = date.toString();
			customerdetails1.getSanctionLetter().setSanctionDate(curdate);
			cell.setPhrase(
					new Phrase(String.valueOf(customerdetails1.getSanctionLetter().getSanctionDate()), font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Total loan Amount with Intrest", font));
			table.addCell(cell);

			document.add(table);

			Font titlefont3 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			Paragraph paracontent2 = new Paragraph(content2, titlefont3);
			document.add(paracontent2);
			document.close();
			
			ByteArrayInputStream byt = new ByteArrayInputStream(opt.toByteArray());
			byte[] bytes = byt.readAllBytes();
			customerdetails1.getSanctionLetter().setSanctionLetter(bytes);
	
			return cr.save(customerdetails1);
		}
		else 
		{
			return null;
		}	
	}
	}

