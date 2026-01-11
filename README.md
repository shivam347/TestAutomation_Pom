# Selenium Test Automation with Multi-Browser Support

This project includes a TestNG test suite configured to run tests on multiple browsers (Chrome, Firefox, Edge).  
A ThreadLocal-based DriverFactory is used to manage WebDriver instances safely during parallel execution.

## Features Added

### ✔ Multi-Browser Test Suite
A TestNG suite file is added to run the same tests on different browsers.  
The browser name is passed as a parameter, allowing parallel execution.

```xml
<suite name="OrangeHRM Suite">

    <listeners>
        <listener class-name="orangehrm.listener.TestListener"/>
    </listeners>

    <test name="Chrome Test">
        <parameter name="browser" value="chrome" />
        <classes>
            <class name="orangehrm.pagestest.LoginPageTest" />
        </classes>
    </test>

    <test name="firefox-test">
        <parameter name="browser" value="firefox" />
        <classes>
            <class name="orangehrm.pagestest.LoginPageTest" />
        </classes>
    </test>

    <test name="Edge-test">
        <parameter name="browser" value="edge" />
        <classes>
            <class name="orangehrm.pagestest.LoginPageTest" />
        </classes>
    </test>

</suite>



### ✔ ThreadLocal Driver (DriverFactory)
A `DriverFactory` class is added to store and retrieve the WebDriver instance using ThreadLocal.  
This ensures each test method gets its own browser instance and avoids cross-thread conflicts.

### ✔ Screenshot Capturing Using DriverFactory Driver
A `ScreenshotUtil` class is implemented to capture screenshots.  
It retrieves the correct driver using: DriverFactory.getDriver()

### Added plugin to build in pom.xml file

<plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.3.0</version>
            <configuration>
                <suiteXmlFiles>
                    <suiteXmlFile>testng.xml</suiteXmlFile>
                </suiteXmlFiles>
            </configuration>
        </plugin>



