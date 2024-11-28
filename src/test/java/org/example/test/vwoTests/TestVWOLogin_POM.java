package org.example.test.vwoTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonToAllPage;
import org.example.driver.DriverManager;
import org.example.pages.pageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM extends CommonToAllPage {


    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);

    @Test
    public void testLoginNegativeVWO() {
        logger.info("Starting the Testcases");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        logger.info("Opening the URL");
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
        logger.info("Verifying the Username is the " + error_msg_text);
        assertThat(error_msg_text).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));
    }

}
