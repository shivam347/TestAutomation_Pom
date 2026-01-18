package herokuapp.pagestest;


import herokuapp.basetest.BaseTest;
import herokuapp.driver.DriverFactory;
import herokuapp.pages.HoversPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FT18_HoversTest extends BaseTest {

    @Test
    public void verifyHoverUserProfile() {

        DriverFactory.getDriver().findElement(By.linkText("Hovers")).click();

        HoversPage page = new HoversPage(DriverFactory.getDriver());

        // There are 3 users (index 0,1,2)
        for (int i = 0; i < 3; i++) {
            page.hoverUser(i);

            String username = page.getUserName(i);
            Assert.assertTrue(username.contains("user"), 
                    "Username not shown for user index: " + i);

            Assert.assertTrue(page.isProfileLinkVisible(i),
                    "Profile link not visible for user index: " + i);
        }
    }
}
