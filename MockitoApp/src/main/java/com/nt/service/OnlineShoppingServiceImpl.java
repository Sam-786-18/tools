package com.nt.service;

import com.nt.ExternalService.PayPalservice;
import com.nt.dto.TrasactionDetails;

public class OnlineShoppingServiceImpl implements OnlineShoppingService {
private PayPalservice extService;

public void setExtService(PayPalservice extService) {
	this.extService = extService;
}
	@Override
	public String payment(int cardNo, float amount) {
	boolean status=false;
	TrasactionDetails txDetails=null;
	//use external service
	//verify card no
	status=extService.verifyCardNumber(cardNo);
	if(status){
		//go for payment
		txDetails=extService.doPayment(cardNo, amount);
		return "Payment done for "+cardNo+" for amount "+amount+" using CardTye "+txDetails.getCardType();
		
	}
	else
	{
		return "invalid cardNo";
	}
	}

}
