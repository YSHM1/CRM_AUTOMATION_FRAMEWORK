package org.crm.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementationClass implements IRetryAnalyzer {

	int count = 0;
	int countLimit = 5;

	@Override
	public boolean retry(ITestResult result) {
		while (count < countLimit) {
			count++;
			return true;
		}
		return false;
	}

}
