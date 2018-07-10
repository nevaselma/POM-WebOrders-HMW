package pomdesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.OrderPage;
import pages.WebOrdersLoginPage;


public class OrderPageTests {
	
	WebDriver driver;
	String userId = "Tester";
	String password = "test";
	WebOrdersLoginPage loginPage;
	AllOrdersPage orders;
	String custName = "John Smith";

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	
	@Test
	public void orderProductTest() throws InterruptedException {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		loginPage = new WebOrdersLoginPage(driver);
		loginPage.login(userId, password);
		orders = new AllOrdersPage(driver);
		orders.orderTab.click();
		
		OrderPage order = new OrderPage(driver);
		Select products = new Select(order.product);
		products.selectByValue("FamilyAlbum");
		order.quantity.sendKeys(Keys.BACK_SPACE);
		order.quantity.sendKeys("2");
		order.customerName.sendKeys(custName);
		order.street.sendKeys("111 Palm St");
		order.city.sendKeys("Ames");
		order.state.sendKeys("OR");
		order.zipCode.sendKeys("11112");
		order.card.click();
		order.cardNumber.sendKeys("1234567891011");
		order.expDate.sendKeys("03/20");
		order.processButton.click();
		
		WebElement actual = order.orderAdded;
		Assert.assertTrue(actual.isDisplayed());
		
		orders.viewAllOrders.click();
		Thread.sleep(1000);
		String actualName = driver.findElement(By.xpath("//table[@class = 'SampleTable']/tbody/tr[2]/td[2]")).getText();
		
		Assert.assertEquals(actualName, custName);
		System.out.println(actualName + " " + custName);
	}


}
