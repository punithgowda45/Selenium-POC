package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	@FindBy(id="username") private WebElement unTB;
	@FindBy(name="pwd") private WebElement pwdn;
	@FindBy(xpath="//div[text()='Login ']") private WebElement login;
	@FindBy(xpath="//span[contains(text(),'invalid')]") private WebElement errMsg;
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setUN(String un) {
		unTB.sendKeys(un);
	}
	public void setpwd(String PW) {
		pwdn.sendKeys(PW);
	}
	public void loginclick() {
		login.click();
	}
	public boolean verifyErrmsgDisplayed(WebDriver driver){
		try{
			System.out.println(errMsg.isDisplayed());
			System.out.println("Error message displayed");
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}
}
