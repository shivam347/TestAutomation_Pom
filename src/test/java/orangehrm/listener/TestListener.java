package orangehrm.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import orangehrm.utility.ScreenshotUtil;

public class TestListener implements ITestListener {

    ScreenshotUtil shot = new ScreenshotUtil();


    @Override
    public void onStart(ITestContext context){

    }

    @Override
    public void onTestSuccess(ITestResult result){

        shot.capture(result.getName() + "_PASSED");

    }

    @Override
    public void onTestFailure(ITestResult result){
       shot.capture(result.getName() + "_FAILED");
    }
    
}
