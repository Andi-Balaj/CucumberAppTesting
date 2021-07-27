package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage {

    private String baseUrl = "http://localhost:4200";
    //private String driverPath = "/home/andibalaj/Downloads/geckodriver-v0.29.1-linux64/geckodriver";
    @FindBy(xpath = "//input[contains(@type,'text')]")
    private WebElement usernameElement;
    @FindBy(xpath = "//input[contains(@type,'password')]")
    private WebElement passwordElement;
    @FindBy(xpath = "//button[@class='btn btn-outline-primary'][contains(.,'Login')]")
    private WebElement loginButtonElement;
    @FindBy(xpath = "//button[@class='btn'][contains(.,'arrow_back')]")
    private WebElement backButton;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
