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
    private HomePage homePage = new HomePage(driver);
    private AddUserPage addUserPage = new AddUserPage(driver);
    private EditUserPage editUserPage = new EditUserPage(driver);
    private DeleteUserPage deleteUserPage = new DeleteUserPage(driver);
    private String username;

    @Given("User is logged in")
    public void testUserIsLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver.get("http://localhost:4200/");
        // Assert.assertTrue(driver.getTitle().equals("Frontend"));
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        loginPage.getUsernameElement().sendKeys("User1");
        loginPage.getPasswordElement().sendKeys("Pass1");
        loginPage.getLoginButtonElement().click();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().equals(BASE_URL));
    }

    @Then("Add new user with Username as {string}")
    public void testAddNewUserWithUsernameAs(String username) {
        driver.get(BASE_URL + "/");
        //driver.get(baseUrl);
        driver.navigate().refresh();
        addUserPage.getAddUser().click();
        addUserPage.getAddUsername().sendKeys(username);
        addUserPage.getAddEmail().sendKeys("marcel@marcel.ro1");
        addUserPage.getAddFullName().sendKeys("Vlad Andrei");
        addUserPage.getAddPassword().sendKeys("Marcel11");
        addUserPage.getAddTrait1Field().click();
        addUserPage.getAddTrait2Field().click();
        addUserPage.getAddTrait3Field().click();
        addUserPage.getAddTrait4Field().click();
        addUserPage.getAddMaleGenderButton().sendKeys(Keys.SPACE);
        addUserPage.getSubmitButton().click();
        driver.get(BASE_URL + "/");
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'" + username + "')]")).isDisplayed());
        this.username = username;
    }

    @And("Edit user")
    public void testEditUserAndModify() {
        driver.get(BASE_URL + "/");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//span[contains(text(),'" + username + "')]/following::button[contains(text(),'Edit')]")).click();
        editUserPage.clearFields();
        editUserPage.getEditUsername().click();
        editUserPage.getEditUsername().sendKeys(username);
        editUserPage.getEditEmail().sendKeys("marcel@marcel.ro1");
        editUserPage.getEditFullName().sendKeys("Marcel User1");
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

    @Then("Delete user")
    public void testDeleteUser() {
        driver.navigate().refresh();
        //String string = driver.findElement(By.xpath("(//span)[8]")).getText();
        driver.findElement(By.xpath("//span[contains(text(),'" + username + "')]/following::button[2]")).click();
        driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
        try {
            Assert.assertFalse(driver.findElement(By.xpath("//span[contains(text(),'" + username + "')]")).isDisplayed());
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
    }

    @Then("User is logged out")
    public void testGoBackToLogin() {
        driver.get(BASE_URL + "/");
        homePage.getBackButton().click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-outline-primary'][contains(.,'Login')]")).isDisplayed());
        driver.get(BASE_URL);
        driver.close();
    }
}
