package herokuapp.pagestest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import herokuapp.basetest.BaseTest;
import herokuapp.driver.DriverFactory;
import herokuapp.pages.ABTestingPage;

public class FT01_ABTestingTest extends BaseTest {

    @Test
    public void verifyHeadingText() {

        // Navigate to the page
        DriverFactory.getDriver().findElement(By.linkText("A/B Testing")).click();

        // Initialize AbTesting page object
        ABTestingPage page = new ABTestingPage(DriverFactory.getDriver());

        // Fetching heading
        String heading = page.getText();

        // verify heading matches one of the two variations
        Assert.assertTrue(heading.equals("A/B Test Control") ||
                heading.equals("A/B Test Variation 1"),
                "Unexpected Heading:  " + heading);

    }

}
