package com.example.Edufinder.Service;

import java.io.File;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.Edufinder.entity.Application_entity;
import com.example.Edufinder.entity.Payment_entity;
import com.example.Edufinder.repo.Application_repo;
import com.example.Edufinder.repo.Payment_repo;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
@Service
public class Payment_service {

    @Value("${razorpay.key}")
    private String key;

    @Value("${razorpay.secret}")
    private String secret;

    @Autowired
    private Payment_repo paymentRepo;

    @Autowired
    private Application_repo applicationRepo;

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private Email_Service emailService;

    /* ================= CREATE ORDER ================= */
    public JSONObject createOrder(Integer applicationId, Double amount)
            throws RazorpayException {

        RazorpayClient client = new RazorpayClient(key, secret);

        JSONObject options = new JSONObject();
        options.put("amount", amount * 100); // paisa
        options.put("currency", "INR");
        options.put("receipt", "app_" + applicationId);

        Order order = client.orders.create(options);

        Payment_entity payment = new Payment_entity();
        payment.setApplicationId(applicationId);
        payment.setAmount(amount);
        payment.setRazorpayOrderId(order.get("id").toString());
        payment.setStatus("CREATED");

        paymentRepo.save(payment);

        JSONObject res = new JSONObject();
        res.put("orderId", order.get("id").toString()); // ✅ FIX
        res.put("amount", amount);
        res.put("currency", "INR");

        return res;
    }

    /* ================= VERIFY PAYMENT ================= */
    public void verifyPayment(JSONObject data) {

        String orderId = data.getString("razorpay_order_id");
        String paymentId = data.getString("razorpay_payment_id");

        Payment_entity payment =
                paymentRepo.findByRazorpayOrderId(orderId)
                        .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setRazorpayPaymentId(paymentId);
        payment.setStatus("PAID");
        paymentRepo.save(payment);

        Application_entity app =
                applicationRepo.findById(payment.getApplicationId())
                        .orElseThrow(() -> new RuntimeException("Application not found"));

        app.setStatus("PAID");
        applicationRepo.save(app);

        // 🔥 Generate receipt PDF
        File receipt = receiptService.generateReceipt(app, payment);

        // 🔥 Send email with receipt
        emailService.sendReceiptEmail(
                app.getEmail(),
                app.getFullName(),
                app.getItemName(),
                receipt
        );

        // 🧹 Delete temp file
        receipt.delete();
    }
    
    public List<Payment_entity> getAllPayments() {
        return paymentRepo.findAll();
    }

}
