package com.telran.contacts;

import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void openHomePageTest(){
        System.out.println("Site opend!!");
        //verify to  displayed Home Component form
       // isComponentFormPresent();
        //System.out.println("Component Form:" + isComponentFormPresent());
        //isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        app.isComponentFormPresent();
    }


}
