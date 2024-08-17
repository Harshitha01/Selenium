package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends AbstractComponent {
    WebDriver d;
    public CartPage(WebDriver d) {
        super(d);
        this.d = d;
        PageFactory.initElements(d,this);

    }
    //PageFactory
    @FindBy(css=".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(xpath = "//*[@class = 'totalRow']/button")
    WebElement checkoutEle;

    public boolean verifyProductDisplay(String ProductName) {
        return cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
    }
    public checkOutPage goToCheckout() {
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));

        // Check if the element is present and visible
        if (!isElementVisible(checkoutEle)) {
            List<WebElement> iframes = d.findElements(By.tagName("iframe"));
            for (WebElement iframe : iframes) {
                d.switchTo().frame(iframe);
                if (isElementVisible(checkoutEle)) {
                    break;
                }
                d.switchTo().defaultContent(); // switch back to the main document
            }
        }

        wait.until(ExpectedConditions.visibilityOf(checkoutEle));
        checkoutEle.click();
        return new checkOutPage(d);
    }

    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
    }

