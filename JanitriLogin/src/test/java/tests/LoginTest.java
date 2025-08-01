package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poc.BasePage;
import poc.LoginPage;
public class LoginTest extends  BasePage { 
LoginPage loginPage;

@BeforeMethod
public void initPage() {
loginPage = new LoginPage(driver);
}

@Test
	public void testLoginButtonDisabledWhenFieldAreEmpty() {
      Assert.assertFalse(loginPage.isLoginButtonEnabled());
  }


  @Test
  public void testPasswordMaskedbutton() {
      Assert.assertTrue(loginPage.isPasswordMasked());
      loginPage.togglePasswordVisibility();
      Assert.assertFalse(loginPage.isPasswordMasked());
  }

  @Test
  public void testInvalidLoginShowErrorMsg() throws InterruptedException {
      loginPage.enterUserId("jnfeijein@gmail.com");
      loginPage.enterPassword("wrongpass");
      loginPage.clickLogin();
      Thread.sleep(5000);
      Assert.assertTrue(loginPage.isErrorMessageDisplayed());
      Thread.sleep(1000);
  }
{

}
}
