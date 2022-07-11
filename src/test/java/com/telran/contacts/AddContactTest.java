package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AddContactTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions()
    {
        if(!app.getHeader().isLoginLinkPresent()){
            app.getUser().click(By.xpath("//button[contains(.,'Sign Out')]"));
        }else {
            app.getUser().login();
        }
    }
    @Test
    public void addContactPositiveTest(){
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Vadim"));
    }
    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }


}