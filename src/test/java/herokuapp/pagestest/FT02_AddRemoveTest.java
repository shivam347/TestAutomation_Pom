package herokuapp.pagestest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import herokuapp.basetest.BaseTest;
import herokuapp.driver.DriverFactory;
import herokuapp.pages.AddRemovePage;

public class FT02_AddRemoveTest extends BaseTest {

    @Test
    public void verifyAddRemoveTest() {

        // first we navigate to the link
        DriverFactory.getDriver().findElement(By.linkText("Add/Remove Elements")).click();

        // create object of addRemovePage class
        AddRemovePage page = new AddRemovePage(DriverFactory.getDriver());

        // click on addbutton
        page.clickAddButton();
        page.clickAddButton();
        page.clickAddButton();
        // now check the delete button
        Assert.assertEquals(page.getdeletebuttonCount(), 3, "Delete button appeared");

        // Now call method which will delete all the Delete button
        page.deleteAllButton();
        Assert.assertEquals(page.getdeletebuttonCount(), 0, "No delete button is present");
    }

}
