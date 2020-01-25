package com.nt.dto;

import java.util.Date;

public class TrasactionDetails {
private int cardNo;
private String cardType;
private float amount;
private Date txDate;
public int getCardNo() {
	return cardNo;
}
public void setCardNo(int cardNo) {
	this.cardNo = cardNo;
}
public String getCardType() {
	return cardType;
}
public void setCardType(String cardType) {
	this.cardType = cardType;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
public Date getTxDate() {
	return txDate;
}
public void setTxDate(Date txDate) {
	this.txDate = txDate;
}
@Override
public String toString() {
	return "TrasactionDetails [cardNo=" + cardNo + ", cardType=" + cardType + ", amount=" + amount + ", txDate="
			+ txDate + "]";
}

}
