package herokuapp.pagestest;


import herokuapp.basetest.BaseTest;
import herokuapp.dataproviderheroku.DataProviderHeroku;
import herokuapp.driver.DriverFactory;
import herokuapp.pages.StatusCodesPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FT20_StatusCodesTest extends BaseTest {

    @Test(dataProvider = "StatusCode", dataProviderClass = DataProviderHeroku.class)
    public void verifyStatusCodeMessage(String code) {

        DriverFactory.getDriver().findElement(By.linkText("Status Codes")).click();

        StatusCodesPage page = new StatusCodesPage(DriverFactory.getDriver());

        // choose a simple code
        page.clickStatusCode(code);

        String message = page.getStatusMessage();

        Assert.assertTrue(message.contains(code),
                "Status message does not contain expected code: " + code);
        
       
    }
}
