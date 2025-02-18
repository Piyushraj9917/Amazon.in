package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {


    @Override
    public boolean retry(ITestResult result) {
        int Count=0;
        int MaxCount=1;
        if(Count<MaxCount)
        {
            Count++;
            return true;
        }
        return false;
    }
}
