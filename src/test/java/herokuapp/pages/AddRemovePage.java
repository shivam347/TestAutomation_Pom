package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import orangehrm.utility.WaitUtil;

public class AddRemovePage {

    public static final Logger log = LogManager.getLogger(AddRemovePage.class);

    private WebDriver driver;

    public AddRemovePage(WebDriver driver) {
        Reporter.log("Initializing Add Remove Page", true);
        this.driver = driver;
        PageFactory.initElements(driver, this); // helps us to use the annotation @Findby
    }

    // so we have two webElement to get one is add button and second is delete
    // button
    @FindBy(xpath = "//button[text() =  'Add Element']")
    private WebElement addButton;

    @FindBy(css = "button.added-manually")
    private List<WebElement> deleteButton;

    /* Method to check add button is clickable or not */
    public void clickAddButton() {
        Reporter.log("Initialization of Add Button", true);
        WaitUtil.waitForClickable(driver, addButton).click();
        log.info("Add button clicked");

    }

    /* Method to get the count of delete button */
    public int getdeletebuttonCount() {
        return deleteButton.size();
    }

    /* Method to delete any delete button */
    public void deleteAllButton() {
        By deleteBtnLocator = By.cssSelector("button.added-manually");

        while(deleteButton.size() > 0) {
            WaitUtil.waitForClickable(driver, deleteBtnLocator);
           
            driver.findElement(deleteBtnLocator).click();
        }

    }

}
