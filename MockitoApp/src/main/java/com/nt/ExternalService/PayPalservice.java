package com.nt.ExternalService;

import com.nt.dto.TrasactionDetails;

public interface PayPalservice {
public boolean verifyCardNumber(int cardNo);
public TrasactionDetails doPayment(int cardNo,float amount);
}
