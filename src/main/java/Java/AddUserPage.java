package Java;

import lombok.Getter;
//import jdk.nashorn.internal.objects.annotations.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AddUserPage {
    private String baseUrl = "http://localhost:4200/users";
    //private String driverPath = "/home/andibalaj/Downloads/geckodriver-v0.29.1-linux64/geckodriver";
    @FindBy(xpath = "(//span[contains(.,'Add user')])[2]")
    private WebElement addUser;
    @FindBy(xpath = "//input[contains(@formcontrolname,'username')]")
    private WebElement addUsername;
    @FindBy(xpath = "//input[contains(@formcontrolname,'email')]")
    private WebElement addEmail;
    @FindBy(xpath = "//input[contains(@formcontrolname,'fullName')]")
    private WebElement addFullName;
    @FindBy(xpath = "//input[contains(@formcontrolname,'password')]")
    private WebElement addPassword;
    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[1]")
    private WebElement addTrait1Field;
    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[2]")
    private WebElement addTrait2Field;
    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[3]")
    private WebElement addTrait3Field;
    @FindBy(xpath = "(//span[contains(@class,'mat-checkbox-inner-container')])[4]")
    private WebElement addTrait4Field;
    //@FindBy(xpath = "(//span[contains(@class,'mat-radio-outer-circle')])[1]")
    @FindBy(xpath = "(//input)[9]")
    private WebElement addMaleGenderButton;
    //@FindBy(xpath = "(//span[contains(@class,'mat-radio-outer-circle')])[2]")
    @FindBy(xpath = "(//input)[10]")
    private WebElement addFemaleGenderButton;
    //@FindBy(xpath = "(//span[contains(@class,'mat-radio-outer-circle')])[3]")
    @FindBy(xpath = "(//input)[11]")
    private WebElement addApacheHelicopterGenderButton;
   // @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Submit')]")y
    @FindBy(xpath = "//span[contains(.,'Submit')]")
    private WebElement submitButton;
    @FindBy(xpath = "//i[contains(@class,'fas fa-times fa-3x')]")
    private WebElement cancelButton;
    private WebDriver driver;

    public AddUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
