package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    private By loginLink= By.cssSelector("[href*='sign_in']");

    @FindBy(how= How.CSS,using = "[class='text-center'] h2")
    private WebElement centerText;
    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage getLoginLink()
    {
      driver.findElement(loginLink).click();
      return new LoginPage(driver);
    }
    public WebElement getCenterText()
    {
        return centerText;
    }
}
