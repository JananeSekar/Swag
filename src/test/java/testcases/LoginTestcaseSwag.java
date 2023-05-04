package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.SwagLoginPage;

public class LoginTestcaseSwag extends SwagBaseClass{

	@Test
	public void test1() throws FilloException {
		SwagLoginPage login = new SwagLoginPage(driver);
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test1'");
		recordset.next();
		
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		login.LoginFunction(UserName,Password);
	}
	@Test
		public void test2() throws FilloException {
		SwagLoginPage login = new SwagLoginPage(driver);
			Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test2'");
			recordset.next();			
			String UserName = recordset.getField("UserName");
			String Password = recordset.getField("Password");	
			login.LoginFunction(UserName,Password);
			WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
			
			String ActError = error.getText();
			String ExpError = "Epic sadface: Username and password do not match any user in this service";
			
			Assert.assertEquals(ActError, ExpError);
	}	
	

}
