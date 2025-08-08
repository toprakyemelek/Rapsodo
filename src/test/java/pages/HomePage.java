package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[@aria-label='Rapsodo logo redirects to home']//*[name()='svg']")
    public WebElement homepagerapsodologo;

    @FindBy(xpath = "//span[normalize-space()='SHOP']")
    public WebElement shopbutton;

    @FindBy(xpath = "(//header//a[contains(@href, '/cart')])[2]")
    public WebElement basketbutton;

    @FindBy(xpath = "//a[normalize-space()='GOLF']")
    public WebElement golfbutton;

    @FindBy(xpath = "//li[@class='BoxedLink Text6 Noselect OpenMenu BarlowSemibold']")
    public WebElement productsbutton;

    @FindBy(xpath = "//div[@id='OpenMenu']//div[3]//div[2]//div[1]//div[1]//a[2]")
    public WebElement shopmlm;

    @FindBy(xpath = "//h1[@class='Acumin RightbarProductName js-rightbar-title']")
    public WebElement mlmtitle;

    @FindBy(xpath = "//span[@class='Barlow Text4'][normalize-space()='$299.99']")
    public WebElement mlmselect;

    @FindBy(xpath = "//button[normalize-space()='Add to Cart']")
    public WebElement addtocartbutton;



}
