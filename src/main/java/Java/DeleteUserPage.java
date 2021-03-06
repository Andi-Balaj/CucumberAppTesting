package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class DeleteUserPage {
    @FindBy(xpath = "(//button[contains(.,'Delete')])[1]")
    private WebElement deleteUser;
    @FindBy(xpath = "(//i[contains(@class,'fas fa-user fa-4x')])[1]")
    private WebElement username;
    @FindBy(xpath = "//button[@color='success'][contains(.,'Yes')]")
    private WebElement yes;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Cancel')]")
    private WebElement no;
    private WebDriver driver;

    public DeleteUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
