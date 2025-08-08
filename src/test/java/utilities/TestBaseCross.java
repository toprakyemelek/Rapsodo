package utilities;

import org.testng.annotations.AfterMethod;

public class git initTestBaseCross {

    @AfterMethod
    public void tearDown(){

        Driver.quitDriver();
    }
}
