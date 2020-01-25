package com.nt.service;

public class BankLoanServiceImpl implements BankLoanServices {

	@Override
	public float calIntrAmt(float pAmt, float rate, float time) throws IllegalArgumentException {
		float intrAmt=0.0f;
		/*intrAmt=pAmt*rate*time/100.0f;
		
		return intrAmt;*/
		
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){}
		if(pAmt<0||rate<=0||time<=0)
			throw new IllegalArgumentException("Invalid inputs");
		intrAmt=pAmt*rate*time/100.0f;
				return intrAmt;
		
	}//method

	@Override
	public boolean isAccountBlocked(int accNo) {
		if(accNo<=0)
			throw new IllegalArgumentException("Invalid Account No.");
		if(accNo>=10000 && accNo<=20000)
		return true;
		else
			return false;
	}

}//class
