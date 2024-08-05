package com.example.payment.responsedto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentResponse {

    private boolean success;
    private String transactionId;
    private String message;

}
