package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasketPage {
    public BasketPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@name='checkout']")
    public WebElement checkoutbutton;

    @FindBy(xpath = "//p[normalize-space()='Your cart is currently empty.']")
    public WebElement sepetbostext;

    @FindBy(xpath = "//div[@class='js-qty__wrapper']//button[@aria-label='Increase item quantity by one']//*[name()='svg']")
    public WebElement urunarttirmaartibutton;

    @FindBy(xpath = "//input[@id='cart_updates_52551486898547:2569949b0ce8d272add21d81a6e645c3']")
    public WebElement urunmiktar;

    @FindBy(xpath = "//div[@class='limoniapps-discountninja-cart-subtotal-price']")
    public WebElement ikiuruntoplamfiyat;
}
