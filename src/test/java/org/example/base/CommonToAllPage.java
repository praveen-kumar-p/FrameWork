package org.example.base;

import org.example.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CommonToAllPage {


    @BeforeTest
    public void setUp(){
        DriverManager.init();
    }

    // Who will close the Webdriver
    @AfterTest
    public void tearDown(){
        DriverManager.down();
    }
}
