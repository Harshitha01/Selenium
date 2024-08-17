package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver w;

    public LandingPage(WebDriver d) {
        super(d);
        this.w = d;
        PageFactory.initElements(d,this);
    }

    //WebElement userEmail = w.findElement(By.id("userEmail"));

    //PageFactory
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement submit;

    public void loginApplication (String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submit.click();

    }
    public void goTo() {
        w.get("https://rahulshettyacademy.com/client/");
    }
}
