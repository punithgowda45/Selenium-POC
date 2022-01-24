package scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.Loginpage;

public class Invalidlogin extends BaseTest{
		
	@Test(priority=2)
	public void testInvalidlogin() throws EncryptedDocumentException, FileNotFoundException, IOException {
		String un=Excel.Getdata(XL_path, "Invalid_data", 1, 0);
		String pw=Excel.Getdata(XL_path, "Invalid_data", 1, 1);
		
		Loginpage login=new Loginpage(driver);
		login.setUN(un);
		login.setpwd(pw);
		login.loginclick();
		boolean result =login.verifyErrmsgDisplayed(driver);
		Assert.assertEquals(result, true);
		if(result==true) {
			screenshot();
		}
		
		
		
//		https://github.com/punithgowda45/POC.git
//		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
		
	}
}