package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmationPage {
    WebDriver d;

    public confirmationPage(WebDriver d) {
        super();
        this.d = d;
        PageFactory.initElements(d,this);
    }

    @FindBy(xpath="//*[@class = 'hero-primary']")
    WebElement confirmationMessage;

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
