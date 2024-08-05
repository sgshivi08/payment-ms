package com.example.payment.service;

import com.example.payment.entity.Payment;
import com.example.payment.repo.PaymentRepository;
import com.example.payment.requestdto.PaymentRequest;
import com.example.payment.responsedto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        // Simulate payment processing logic
        Payment payment = new Payment();
        payment.setTicketId(paymentRequest.getTicketId());
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setStatus("SUCCESS");
        payment.setTransactionId(UUID.randomUUID().toString());

        paymentRepository.save(payment);

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setSuccess(true);
        paymentResponse.setMessage("Payment processed successfully");
        paymentResponse.setTransactionId(payment.getTransactionId());

        return paymentResponse;
    }
}
