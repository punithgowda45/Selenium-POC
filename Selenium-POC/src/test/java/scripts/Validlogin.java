package scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.Homepage;
import pages.Loginpage;





public class Validlogin extends BaseTest{
		
	@Test(priority=1)
	public void testValidlogin() throws EncryptedDocumentException, FileNotFoundException, IOException {
		String un=Excel.Getdata(XL_path, "Valid_data", 1, 0);
		String pw=Excel.Getdata(XL_path, "Valid_data", 1, 1);
		
		Loginpage login=new Loginpage(driver);
		login.setUN(un);
		login.setpwd(pw);
		login.loginclick();
		
		Homepage home=new Homepage(driver);
		boolean result = home.verifyhomepage(wait, "actiTIME");
		Assert.assertEquals(result, true);
		
		if(result==true) {
			home.logout();
			System.out.println("Logout done");
		}
		
//		https://github.com/punithgowda45/Selenium-POC.git
//		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
		
	}
}