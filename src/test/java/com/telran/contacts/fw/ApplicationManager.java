package com.telran.contacts.fw;

import com.telran.contacts.fw.ContactHelper;
import com.telran.contacts.fw.HeaderHelper;
import com.telran.contacts.fw.UserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    HeaderHelper header;
    UserHelper user;
    ContactHelper contact;

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }
    public  HeaderHelper getHeader() {return header;}

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        header = new HeaderHelper(driver);


    }

    public boolean isComponentFormPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size() > 0;
    }

    public void stop() {
        driver.quit();
    }


}
