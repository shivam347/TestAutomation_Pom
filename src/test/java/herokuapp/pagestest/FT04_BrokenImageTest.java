package herokuapp.pagestest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import herokuapp.basetest.BaseTest;
import herokuapp.driver.DriverFactory;
import herokuapp.pages.BrokenImagePage;

public class FT04_BrokenImageTest extends BaseTest {

    @Test
    public void verifyBrokenImages(){

        // first navigate to the page 
        DriverFactory.getDriver().findElement(By.linkText("Broken Images")).click();

        // Now create object of BrokenImageTest class
        BrokenImagePage brokenImage = new BrokenImagePage(DriverFactory.getDriver());

        brokenImage.allImageLoaded();

        // As i want result get passed for images are broken 
        Assert.assertFalse(brokenImage.allImageLoaded(), "All images loaded Successfully");


    }
    
}
