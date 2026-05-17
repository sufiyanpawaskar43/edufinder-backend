package com.example.Edufinder.Service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class Email_Service {

    @Autowired
    private JavaMailSender javaMailSender;

    /* ===== SIMPLE EMAIL ===== */
    @Async
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(message);
        mail.setFrom("sufiyanpawaskar43@gmail.com");
        javaMailSender.send(mail);
    }

    /* ===== APPLICATION CONFIRMATION ===== */
    public void sendApplicationConfirmation(String to, String itemName) {
        sendEmail(
                to,
                "Application Received - EduFinder",
                "Hello,\n\nYour application for " + itemName +
                        " has been submitted successfully.\n\nEduFinder Team"
        );
    }

    /* ===== STATUS UPDATE ===== */
    public void sendStatusUpdateEmail(String to, String itemName, String status) {
        sendEmail(
                to,
                "Application Status Update - EduFinder",
                "Hello,\n\nYour application for " + itemName +
                        " has been " + status + ".\n\nEduFinder Team"
        );
    }

    /* ===== RECEIPT EMAIL (PDF ATTACHMENT) ===== */
    @Async
    public void sendReceiptEmail(
            String to,
            String studentName,
            String itemName,
            File receiptPdf
    ) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setFrom("sufiyanpawaskar43@gmail.com");
            helper.setSubject("🎓 Admission Confirmed – EduFinder");

            helper.setText(
                    "Hello " + studentName + ",\n\n" +
                    "Your payment has been successfully received.\n\n" +
                    "Admission Item: " + itemName + "\n\n" +
                    "Your receipt is attached.\n\n" +
                    "Regards,\nEduFinder Team"
            );

            helper.addAttachment(
                    "Admission_Receipt.pdf",
                    new FileSystemResource(receiptPdf)
            );

            javaMailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
