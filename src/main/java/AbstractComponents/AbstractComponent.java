package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractComponent {
    WebDriver driver;
    public AbstractComponent(WebDriver d) {
        this.driver = d;
        //PageFactory.initElements(d,this);
    }

    //PageFactory
    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;

    public void waitForElementToAppear(By findBy) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void goToCartPage() {
        cartHeader.click();
    }

    public void waitForElementToDisappear(WebElement ele) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.invisibilityOf(ele));

    }
}
