package herokuapp.pagestest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import herokuapp.basetest.BaseTest;
import herokuapp.dataproviderheroku.DataProviderHeroku;
import herokuapp.driver.DriverFactory;
import herokuapp.pages.BasicAuthPage;

public class FT03_BasicAuthTest extends BaseTest {

    @Test(dataProvider="BasicAuthData", dataProviderClass = DataProviderHeroku.class)
    public void verifyBasicAuth(String name, String pass, boolean isValid){

        // Navigate to the page
        DriverFactory.getDriver().findElement(By.linkText("Basic Auth")).click();

        BasicAuthPage authPage = new BasicAuthPage(DriverFactory.getDriver());

        // Now call the pom method with credentials
        authPage.loginWithCredentials(name, pass);

        if(isValid){
            Assert.assertTrue(authPage.isSuccessMessageDisplayed(), "Success expected but not found");
        }else{
             Assert.assertTrue(authPage.isLoginFailed(),
                "Congratulation expected but not found!");
        }




    }


    
}
