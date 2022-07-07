package com.telran.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

@BeforeMethod
    public void ensurePrecondition(){
    if(!app.isLoginLinkPresent()){
        app.clickOnSignOutButton();
    } else {
        app.login();
        app.addContact();
    }
}

    @Test
    public void removeContactTest() {
        app.pause(2000);
        int sizeBefore = app.sizeOfContacts();
    app.removeContact();
        app.pause(2000);
        int sizeAfter= app.sizeOfContacts();
    //System.out.println(sizeAfter);
    Assert.assertEquals(sizeAfter,sizeBefore-1);

}

}
