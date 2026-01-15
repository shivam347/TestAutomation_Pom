package herokuapp.dataproviderheroku;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;

public class DataProviderHeroku {

    private static final Logger log = Logger.getLogger(DataProviderHeroku.class);

    @DataProvider(name="BasicAuthData")
    public static Object[][] getBasicAuthData() {
        Reporter.log("Start Inserting Values for BasicAuth", true);

        return new Object[][] {
                { "admin", "admin", true }, // valid
                { "wrong", "admin", false }, // invalid username
                { "admin", "wrong", false }, // invalid password
                { "user", "pass", false } // fully invalid
        };

    }

}
