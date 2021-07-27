package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class EditUserPage {
    private String baseUrl = "http://localhost:4200/users";
    //private String driverPath = "/home/andibalaj/Downloads/geckodriver-v0.29.1-linux64/geckodriver";
    //@FindBy(xpath = "(//button[@class='btn'][contains(.,'Edit')])[1]")
    @FindBy(xpath = "(//button[contains(.,'Edit')])[1]")
    private WebElement editUser;
    @FindBy(xpath = "//input[contains(@formcontrolname,'username')]")
    private WebElement editUsername;
    @FindBy(xpath = "//h1[contains(.,'Arun Li')]")
    private static WebElement username1;
    @FindBy(xpath = "//input[contains(@formcontrolname,'email')]")
    private WebElement editEmail;
    @FindBy(xpath = "//input[contains(@formcontrolname,'fullName')]")
    private WebElement editFullName;
    @FindBy(xpath = "//input[contains(@formcontrolname,'password')]")
    private WebElement editPassword;
    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[1]")
    private WebElement editTrait1Field;
    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[2]")
    private WebElement editTrait2Field;
    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[3]")
    private WebElement editTrait3Field;
    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[4]")
    private WebElement editTrait4Field;
    @FindBy(xpath = "(//span[contains(@class,'mat-radio-outer-circle')])[1]")
    private WebElement editMaleGenderButton;
    @FindBy(xpath = "(//span[contains(@class,'mat-radio-outer-circle')])[2]")
    private WebElement editFemaleGenderButton;
    @FindBy(xpath = "(//span[contains(@class,'mat-radio-outer-circle')])[3]")
    private WebElement editApacheHelicopterGenderButton;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Submit')]")
    private WebElement editSubmitButton;
    @FindBy(xpath = "//i[@class='fas fa-times fa-3x']")
    private WebElement editCancelButton;
    private WebDriver driver;

    public EditUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}