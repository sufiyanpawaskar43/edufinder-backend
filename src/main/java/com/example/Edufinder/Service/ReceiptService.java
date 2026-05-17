package com.example.Edufinder.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.Edufinder.entity.Application_entity;
import com.example.Edufinder.entity.Payment_entity;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ReceiptService {

    public File generateReceipt(
            Application_entity app,
            Payment_entity payment
    ) {
        try {
            File file = File.createTempFile(
                    "receipt_" + app.getId(),
                    ".pdf"
            );

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();

            Font title = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font body = new Font(Font.FontFamily.HELVETICA, 12);

            doc.add(new Paragraph("EduFinder Admission Receipt\n\n", title));

            doc.add(new Paragraph("Student Name: " + app.getFullName(), body));
            doc.add(new Paragraph("Email: " + app.getEmail(), body));
            doc.add(new Paragraph("Item: " + app.getItemName(), body));
            doc.add(new Paragraph("Type: " + app.getItemType(), body));
            doc.add(new Paragraph("Amount Paid: ₹" + payment.getAmount(), body));
            doc.add(new Paragraph(
                    "Payment ID: " + payment.getRazorpayPaymentId(), body));

            doc.add(new Paragraph(
                    "Date: " +
                    app.getAppliedAt()
                       .format(DateTimeFormatter.ofPattern("dd MMM yyyy")),
                    body
            ));

            doc.add(new Paragraph("\nStatus: CONFIRMED", body));

            doc.close();
            return file;

        } catch (Exception e) {
            throw new RuntimeException("Receipt generation failed", e);
        }
    }
}
