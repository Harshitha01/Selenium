package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

public class ProductCatalog extends AbstractComponent {

    WebDriver w;

    public ProductCatalog(WebDriver d) {
        super(d);
        this.w = d;
        PageFactory.initElements(d,this);
    }

    //PageFactory
    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
    WebElement spinner;

    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    public List<WebElement> getProductList() {
//        waitForElementToAppear(productsBy);
//        List<WebElement> productList = w.findElements(productsBy);
//        System.out.println("Number of products found: " + productList.size()); // Debug statement
//        for (WebElement product : productList) {
//            System.out.println(product.getText()); // Debug statement
//        }
//        return productList;
        waitForElementToAppear(productsBy);
        //List<WebElement> productList = w.findElements(productsBy);
        System.out.println("Number of products found: " + products.size());// Debug statement
        return products;
    }

    public WebElement getProductByName(String ProductName) {
//        List<WebElement> products = getProductList();
//        for (WebElement product : products) {
//            String productNameText = product.findElement(By.cssSelector("b")).getText();
//            System.out.println("Product name in list: " + productNameText);  // Debug statement
//            if (productNameText.equals(ProductName)) {
//                return product;
//            }
//        }
        WebElement prod = getProductList().stream().filter(product -> product.findElement(By.xpath("//*[text()='ZARA COAT 3']")).getText().equals(ProductName)).findFirst().orElse(null);
        System.out.println("Product name in list: " + prod);  // Debug statement
        return prod;
    }
    public void addProductToCart(String ProductName) {
        WebElement prod = getProductByName(ProductName);
        if (prod != null) {
            prod.findElement(addToCart).click();
        } else {
            System.out.println("Product with name " + ProductName + " not found");
        }
        //prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);
    }

}
