package com.example.Edufinder.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Edufinder.Service.Payment_service;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class Payment_controller {

    @Autowired
    private Payment_service paymentService;

    // ================= CREATE ORDER =================
    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(
            @RequestParam Integer applicationId,
            @RequestParam Double amount
    ) throws RazorpayException {

        JSONObject response = paymentService.createOrder(applicationId, amount);
        return ResponseEntity.ok(response.toString());
    }

    // ================= VERIFY PAYMENT =================
    @PostMapping("/verify")
    public ResponseEntity<?> verifyPayment(@RequestBody String payload) {

        JSONObject data = new JSONObject(payload);
        paymentService.verifyPayment(data);

        return ResponseEntity.ok("Payment verified successfully");
    }
    
    @GetMapping("/history")
    public ResponseEntity<?> getPaymentHistory() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

}
