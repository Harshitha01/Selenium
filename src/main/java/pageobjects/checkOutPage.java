package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOutPage extends AbstractComponent {
    WebDriver d;

    public checkOutPage(WebDriver d) {
        super(d);
        this.d = d;
        PageFactory.initElements(d,this);
    }
    @FindBy(css="[placeholder='Select Country']")
    WebElement country;

    @FindBy(css=".action__submit")
    WebElement submit;

    @FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
    WebElement ind;

    By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        Actions a = new Actions(d);
        a.sendKeys(country,countryName).build().perform();
        waitForElementToAppear(results);
        ind.click();
    }
    public confirmationPage submitOrder() {
        submit.click();
        return new confirmationPage(d);
    }


}
