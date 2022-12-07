package org.crm.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {

	@Test(retryAnalyzer = org.crm.genericUtility.RetryAnalyzerImplementationClass.class)
	public void retryAnalyzerPractice() {
		System.out.println("ABCD");
		Assert.fail();
	}
}
