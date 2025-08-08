package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ResuableMethods;

import static utilities.Driver.driver;

public class US_001_UrunSepeteEkleme {

    @Test
    public void TC_001(){
        HomePage homePage = new HomePage();
        BasketPage basketPage = new BasketPage();
        Actions actions=new Actions(driver);

        //Ziyaretçi, belirtilen URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Anasayfa'nin goruntulendiği dogrulanır
        Assert.assertTrue(homePage.homepagerapsodologo.isDisplayed());

        //Kullanıcı sağ üst köşedeki “Sepet” (Cart) ikonuna tıklar.
        homePage.basketbutton.click();

        //Sepetin şu an boş olduğunu doğrular.
        Assert.assertTrue(basketPage.sepetbostext.isDisplayed());

        //Kullanıcı “Golf” butonuna tıklar ve “Mobile Launch Monitor (MLM)” ürününü “Products” butonu ile seçer.
        homePage.golfbutton.click();
        homePage.productsbutton.click();

        //“Shop MLM” butonuna basar.
        homePage.shopmlm.click();

        //Sayfa başlığının “Mobile Launch Monitor (MLM)” olduğunu doğrular.
        Assert.assertTrue(homePage.mlmtitle.isDisplayed());

        //Sağ taraftan “MOBILE LAUNCH MONITOR” ürününü seçer.
        ResuableMethods.wait(2);
        homePage.mlmselect.click();

        //Kullanıcı “ADD TO CART” butonuna tıklar.
        homePage.addtocartbutton.click();

        //Kullanıcının sepete yönlendirildiğini doğrular.
        Assert.assertTrue(basketPage.checkoutbutton.isEnabled());

        //Mobile Launch Monitor (MLM) ürününün fiyatının önceki sayfadaki fiyatla aynı olduğunu kontrol eder.
        driver.navigate().back();
        WebElement fiyatOncekiSayfa = driver.findElement(By.xpath("//span[@class='Barlow Text4'][normalize-space()='$299.99']"));
        String fiyatOnceki = fiyatOncekiSayfa.getText().replaceAll("[^0-9.]", "299.99");

        // Yeni sayfadaki MLM fiyatını alır.
        driver.navigate().forward();
        WebElement fiyatYeniSayfa = driver.findElement(By.xpath("//span[contains(text(),'$299.99')]"));
        String fiyatYeni = fiyatYeniSayfa.getText().replaceAll("[^0-9.]", "299.99");
        Assert.assertEquals(fiyatYeni, fiyatOnceki, "MLM fiyatları aynı değil!");

        //Sepette ürün adedi 2 olacak şekilde artırılır.
        basketPage.urunarttirmaartibutton.click();
        ResuableMethods.wait(2);

        //Kullanıcı, “My Cart” (Sepetim) bölümünde 2 ürün olduğunu ve toplam fiyatın $599.98.00 olduğunu doğrular.
        WebElement element = driver.findElement(By.xpath("//*[@id='cart_updates_52551486898547:2569949b0ce8d272add21d81a6e645c3']"));
        String value = element.getAttribute("value");
        Assert.assertEquals(value, "2", "Ürün sayısı 2 değil!");
        WebElement fiyatElementi = driver.findElement(By.xpath("//div[@class='limoniapps-discountninja-cart-subtotal-price']"));
        String fiyatText = fiyatElementi.getText();
        String fiyatSayisi = fiyatText.replaceAll("[^0-9.]", "");
        Assert.assertEquals(fiyatSayisi, "599.98", "Fiyat eşleşmedi!");

        //Sayfa kapanır.
        Driver.quitDriver();

    }
}
