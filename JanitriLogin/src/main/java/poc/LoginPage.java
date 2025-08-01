package poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

    @FindBy(id = "formEmail") WebElement userIdInput;
    @FindBy(name = "password") WebElement passwordInput;
    @FindBy(xpath = "//button[@class=\"login-button\"]") WebElement loginButton;
    @FindBy(xpath = "//img[@alt='Password Not Visible']") WebElement eyeIcon;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserId(String userId) {
        userIdInput.sendKeys(userId);
    }

    public void enterPassword(String pwd) {
        passwordInput.sendKeys(pwd);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public boolean isPasswordMasked() {
        return passwordInput.getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        eyeIcon.click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.getPageSource().contains("Invalid credentials") || driver.findElements(By.className("error")).size() > 0;
    }

}
