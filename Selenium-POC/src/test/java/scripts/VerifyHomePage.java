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

public class VerifyHomePage extends BaseTest{
		
	@Test(priority=3)
	public void testVerifyhomepage() throws EncryptedDocumentException, FileNotFoundException, IOException {
		String un=Excel.Getdata(XL_path, "Valid_data", 1, 0);
		String pw=Excel.Getdata(XL_path, "Valid_data", 1, 1);
		
		Loginpage login=new Loginpage(driver);
		login.setUN(un);
		login.setpwd(pw);
		login.loginclick();
		
		Homepage home=new Homepage(driver);
		boolean result = home.verifyhomepage(wait, "Punith");
		Assert.assertEquals(result, true);
		
		if(result==true) {
			home.logout();
			System.out.println("logout done");
		}
		
//		https://github.com/punithgowda45/POC.git
//		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
		
	}
}