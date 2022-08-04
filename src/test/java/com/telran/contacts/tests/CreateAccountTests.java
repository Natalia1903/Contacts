package com.telran.contacts.tests;

import com.telran.contacts.models.Contact;
import com.telran.contacts.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

        @Test(enabled = false)
        public void registrationPositiveTestFromCSV() {
            //click on the link LOGIN
            app.getUser().registration();
            Assert.assertTrue(app.getHeader().isSignOutButtonPresent());

            }
    @Test
    public void registrationNegativeTest() {
        app.getUser().registration();
        Assert.assertTrue(app.getUser().isAlertPresent());

    }


    @Test(dataProvider = "addNewContactCSV",dataProviderClass = DataProviders.class)
    public void addUserNegativeTestFromCSV(User user) {
        app.getUser().click(By.xpath("//a[contains(text(),'LOGIN')]"));
        app.getUser().registration();
        app.getUser().click(By.xpath("//button[contains(text(),'Registration')]"));


    }


    @AfterMethod(enabled = false)
    public void postCondition(){
        app.getContact().removeContact();
    }


}

