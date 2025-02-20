package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int Count=0;
    int MaxCount=1;

    @Override
    public boolean retry(ITestResult result) {
        if(Count<MaxCount)
        {
            Count++;
            return true;
        }
        return false;
    }
}
