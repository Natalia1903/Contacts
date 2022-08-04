package com.telran.contacts.tests;


import com.telran.contacts.models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AddContactTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
        }
    }

        @Test
        public void addContactPositiveTest () {
            app.getContact().addContact();
            Assert.assertTrue(app.getContact().isContactCreated("Vadim"));
        }

        @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
        public void addContactPositiveTestFromDataProvider (String name, String sName, String phone,
                String email, String address, String des){
            app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
            app.getContact().fillContactForm(new Contact().setName(name)
                    .setSureName(sName)
                    .setPhone(phone)
                    .setEmail(email)
                    .setAddress(address)
                    .setDiscription(des));
            app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
        }

    @Test(dataProvider = "addNewContactCSV",dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @AfterMethod (enabled = false)
    public void postCondition(){
        app.getContact().removeContact();
    }


}
