package herokuapp.pagestest;


import herokuapp.basetest.BaseTest;
import herokuapp.driver.DriverFactory;
import herokuapp.pages.FileUploadPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FT13_FileUploadTest extends BaseTest {

    @Test
    public void verifyFileUpload() {

        // Navigate
        DriverFactory.getDriver().findElement(By.linkText("File Upload")).click();

        FileUploadPage page = new FileUploadPage(DriverFactory.getDriver());

        // Path to upload file (CHANGE THIS PATH)
        String filePath = "C:\\Users\\VIDHI YADAV\\Downloads\\Sample.txt";

        // Perform upload
        page.uploadFile(filePath);
        page.clickUploadButton();

        // Verify filename
        Assert.assertEquals(page.getUploadedFileName(), "Sample.txt",
                "Uploaded filename is incorrect!");
    }
}
