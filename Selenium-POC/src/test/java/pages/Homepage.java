package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	@FindBy(xpath="//a[@id='logoutLink']") private WebElement logoutbtn;
	
public Homepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void logout() {
	logoutbtn.click();
}

public boolean verifyhomepage(WebDriverWait wait,String etitle) {
	try{
		wait.until(ExpectedConditions.titleContains(etitle));
		System.out.println("Home page is displayed");
		return true;
	}
	catch(Exception e) {
		System.out.println("Invalid Page");
		return false;
	}
}	
}
