package com.nt.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AllTestRunner {

	public static void main(String[] args) {
		Result result=JUnitCore.runClasses(AirtmeticServiceTest.class);
		System.out.println("Run Count::"+result.getRunCount());
		System.out.println("Faliure Count::"+result.getFailureCount());
		System.out.println("Ignore Count::"+result.getIgnoreCount());
		for(Failure fail:result.getFailures()){
			System.out.println(fail.toString());
		}
	}
	
}
