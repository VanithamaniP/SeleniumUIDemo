package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    private By emailAddress= By.id("user_email");
    private By password= By.id("user_password");

    private By loginButton=By.name("commit");
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getEmail()
    {
        return driver.findElement(emailAddress);
    }
    public WebElement getPassword()
    {
        return driver.findElement(password);
    }
    public WebElement getLoginButton()
    {
        return driver.findElement(loginButton);
    }

}
