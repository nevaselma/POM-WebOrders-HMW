package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct") 
	public WebElement product;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity") 
	public WebElement quantity;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtName") 
	public WebElement customerName;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2") 
	public WebElement street;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3") 
	public WebElement city;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox4") 
	public WebElement state;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5") 
	public WebElement zipCode;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_cardList_0") 
	public WebElement card;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6") 
	public WebElement cardNumber;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1") 
	public WebElement expDate;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_InsertButton") 
	public WebElement processButton;
	
	@FindBy(xpath="//strong") 
	public WebElement orderAdded;
	
	
	
	
	
}
