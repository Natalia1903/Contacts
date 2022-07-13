package com.telran.contacts.fw;

import com.telran.contacts.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickWithAction(By save){
        Actions actions= new Actions(driver);
        WebElement element = driver.findElement(save);

        actions.moveToElement(element).perform();
        element.click();
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el:contacts){
            if(el.getText().contains(text));
            return true;
        } return false;
    }

    public void addContact() {
        int i=(int) (System.currentTimeMillis())/10000000;
        click(By.xpath("//a[contains(text(),'ADD')]"));
        fillContactForm(new Contact().setName("Goga").setSureName("Vadim").setPhone( "9875643" + i).setEmail( "vadim" + i + "@gmail.com").setAddress("Berlin").setDiscription("des"));
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {

        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getSureName());
        type(By.cssSelector("input:nth-child(3)"), contact.getPfone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAdress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDiscription());
    }

    public int sizeOfContacts() {
    if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }return 0;

    }

    public void removeContact() {
        if(!isContactListEmpty()){
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[contains(.,'Remove')]"));
        }
    }

    public boolean isContactListEmpty() {
    return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }
}
