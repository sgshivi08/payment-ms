package com.example.payment.service;


import com.example.payment.entity.Payment;
import com.example.payment.repo.PaymentRepository;
import com.example.payment.requestdto.PaymentRequest;
import com.example.payment.responsedto.PaymentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processPayment_success() {
        PaymentRequest request = new PaymentRequest();
        request.setTicketId(1);
        request.setAmount(100.0);
        request.setPaymentMethod("credit_card");

        Payment payment = new Payment();
        payment.setId(1L);
        payment.setTicketId(1);
        payment.setAmount(100.0);
        payment.setStatus("SUCCESS");
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentResponse response = paymentService.processPayment(request);
        assertTrue(response.isSuccess());
        assertEquals("Payment processed successfully", response.getMessage());
    }

    @Test
    void processPayment_failure() {
        PaymentRequest request = new PaymentRequest();
        request.setTicketId(1);
        request.setAmount(100.0);
        request.setPaymentMethod("credit_card");

        Payment payment = new Payment();
        payment.setId(1L);
        payment.setTicketId(1);
        payment.setAmount(100.0);
        payment.setStatus("FAILURE");
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentResponse response = paymentService.processPayment(request);
        assertFalse(response.isSuccess());
        assertEquals("Payment failed", response.getMessage());
    }
}
