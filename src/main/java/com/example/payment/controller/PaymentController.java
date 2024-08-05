package com.example.payment.controller;


import com.example.payment.requestdto.PaymentRequest;
import com.example.payment.responsedto.PaymentResponse;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}
