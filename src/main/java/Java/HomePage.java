package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePage {
    private String baseUrl = "http://localhost:4200";
    //private String driverPath = "/home/andibalaj/Downloads/geckodriver-v0.29.1-linux64/geckodriver";
    @FindBy(xpath = "(//span[contains(.,'Add user')])[2]")
    private WebElement addUserButton;
    @FindBy(xpath = "(//button[contains(.,'Delete')])[1]")
    private WebElement deleteFirstUser;
    @FindBy(xpath = "(//button[@class='btn'][contains(.,'Edit')])[1]")
    private WebElement editFirstUser;
    @FindBy(xpath = "//button[@class='btn'][contains(.,'arrow_back')]")
    private WebElement backButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
