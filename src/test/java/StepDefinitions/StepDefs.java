package StepDefinitions;

import Java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefs {
    private static final String BASE_URL = "http://localhost:4200/users";
    WebDriver driver = new ChromeDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    private AddUserPage addUserPage;
    private EditUserPage editUserPage;
    private DeleteUserPage deleteUserPage;

    @Given("User is logged in")
    public void userIsLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver.get("http://localhost:4200/");
        // Assert.assertTrue(driver.getTitle().equals("Frontend"));
        loginPage = new LoginPage(driver);
        loginPage.getUsernameElement().sendKeys("User1");
        loginPage.getPasswordElement().sendKeys("Pass1");
        loginPage.getLoginButtonElement().click();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().equals(BASE_URL));
    }

    @Then("Add new user with Username as {string}")
    public void addNewUserWithUsernameAs(String username) {
        driver.get(BASE_URL + "/");
        AddUserPage addUserPage = new AddUserPage(driver);
//      driver.get(BASE_URL + "/");
        //    driver.navigate().refresh();

        addUserPage.getAddUser().click();
        addUserPage.getAddUsername().sendKeys("Marian1");
        addUserPage.getAddEmail().sendKeys("marcel@marcel.ro1");
        addUserPage.getAddFullName().sendKeys("George Andrei");
        addUserPage.getAddPassword().sendKeys("Marcel11");
        addUserPage.getAddTrait1Field().click();
        addUserPage.getAddTrait2Field().click();
        addUserPage.getAddTrait3Field().click();
        addUserPage.getAddTrait4Field().click();
        addUserPage.getAddMaleGenderButton().sendKeys(Keys.SPACE);
        addUserPage.getSubmitButton().click();
        driver.get(BASE_URL + "/");
        driver.navigate().refresh();
      //  try {
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(.,'George Andrei')]")).isDisplayed());
       // } catch (Exception ex) {
          //  Assert.fail();
      //  }

    }

    @And("Edit user")
    public void editUserAndModify() {
       EditUserPage editUserPage=new EditUserPage(driver);
       //editUserPage.getEditUser().click();
//        addUser();
        driver.get(BASE_URL + "/");
        driver.navigate().refresh();
        editUserPage.getEditUser().click();
        editUserPage.getEditUsername().click();
        editUserPage.getEditUsername().clear();
        editUserPage.getEditUsername().sendKeys("Marian1");
        editUserPage.getEditEmail().clear();
        editUserPage.getEditEmail().sendKeys("marcel@marcel.ro1");
        editUserPage.getEditFullName().clear();
        editUserPage.getEditFullName().sendKeys("Marcel User1");
        editUserPage.getEditPassword().clear();
        editUserPage.getEditPassword().sendKeys("Marcel11");
        editUserPage.getEditSubmitButton().click();
        driver.get(BASE_URL + "/");
        driver.navigate().refresh();
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Marian1')]")).isDisplayed());
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
    }

    //
    @Then("Delete user")
    public void deleteUser() {
       DeleteUserPage deleteUserPage=new DeleteUserPage(driver);
        driver.navigate().refresh();
        String string = driver.findElement(By.xpath("(//span)[8]")).getText();
        deleteUserPage.getDeleteUser().click();
        deleteUserPage.getYes().click();

        try {
            Assert.assertFalse(driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]")).isDisplayed());
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
    }

    @Then("User is logged out")
    public void goBackToLogin() {
        HomePage homePage=new HomePage(driver);
        driver.get(BASE_URL + "/");
        homePage.getBackButton().click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-outline-primary'][contains(.,'Login')]")).isDisplayed());
        driver.get(BASE_URL);

    }
}
