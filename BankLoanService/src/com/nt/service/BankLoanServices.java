package com.nt.service;

public interface BankLoanServices {
	public float calIntrAmt(float pAmt,float rate,float time)throws IllegalArgumentException;
    public boolean isAccountBlocked(int accNo);
}
