package MavenConcept.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.LandingPage;

public class StandaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ProductName = "ZARA COAT 3";
		WebDriverManager.edgedriver().setup();
		WebDriver d = new EdgeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/client/");
//		LandingPage landingpage = new LandingPage(d);
//		landingpage.goTo();
//		landingpage.loginApplication("harshi@example.com","Harshi01051998");
		
		d.findElement(By.id("userEmail")).sendKeys("harshi@example.com");
		d.findElement(By.id("userPassword")).sendKeys("Harshi01051998");
		d.findElement(By.id("login")).click();
		
		List <WebElement> list = d.findElements(By.cssSelector(".mb-3"));
//        for (WebElement element : list) {
//            System.out.println(element);
//        }
		list.stream().filter(product->product.findElement(By.xpath("//*[text()='ZARA COAT 3']")).getText().equals(ProductName)).findFirst().orElse(null);
		
		d.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		WebDriverWait w = new WebDriverWait(d,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		w.until(ExpectedConditions.invisibilityOf(d.findElement(By.cssSelector(".ng-animating"))));
		d.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List <WebElement> cartProducts = d.findElements(By.cssSelector(".cartSection h3"));

		boolean Match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(Match);
		d.findElement(By.cssSelector(".totalRow button")).click();

		Actions a = new Actions(d);
		a.sendKeys(d.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		d.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		d.findElement(By.cssSelector(".action__submit")).click();


		String confirmMessage = d.findElement(By.xpath("//*[@class = 'hero-primary']")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		d.close();






	}

}
