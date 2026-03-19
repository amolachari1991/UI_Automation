package com.listeners;

import com.constants.Environments;
import com.utility.JsonUtility;
import com.utility.PropertiesUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyser implements IRetryAnalyzer {
//    private static final int MAX_ATTEMPT = Integer.parseInt(PropertiesUtility.readProperty(Environments.QA,"MAX_ATTEMPT"));
    private static final int MAX_ATTEMPT = JsonUtility.jsonReader(Environments.QA).getMAX_ATTEMPT();
    private static int currentAttempt = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(currentAttempt <= MAX_ATTEMPT){
            currentAttempt++;
            return true;
        }
        return false;
    }
}
