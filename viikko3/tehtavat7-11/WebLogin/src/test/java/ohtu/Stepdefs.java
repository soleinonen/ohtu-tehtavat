package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new FirefoxDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
    	selectAndClickCommand("login");
    }    
    
    @Given("command new user is selected")
    public void newUserIsSelected() {
    	selectAndClickCommand("register new user");
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String username, String password) {
        selectAndClickCommand("register new user");
        createUserWith(username, password, password);
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) {
    	selectAndClickCommand("register new user");
        createUserWith(username, password, password);
    }


    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        createUserWith(username, password, password);
    }
    
    @When("too short username {string} and a valid password {string} and matching password are given")
    public void tooShortUsernameAndValidPasswordAndMatchingPasswordAreGiven(String username, String password) {
    	createUserWith(username, password, password);
    }
    
    @When("a valid username {string} and too short password {string} are given")
    public void aValidUsernameAndTooShortPasswordAreGiven(String username, String password) {
        createUserWith(username, password, password);
    }

    
    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
    	pageHasContent(error);
    }
    
    @Then("a new user is created")
    public void aNewUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("incorrect username {string} and password {string} are given")
    public void incorrectUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }   
    
    @When("valid username {string} and valid password {string} and invalid password confirmation {string} are given")
    public void validUsernameAndValidPasswordAndInvalidPasswordConfirmationAreGiven(String username, String password, String passwordConfirmation) {
        createUserWith(username, password, passwordConfirmation);
    }

    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
    
    private void selectAndClickCommand(String command) {
    	driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText(command));       
        element.click();   
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void createUserWith(String username, String password, String passwordConfirmation) {
    	assertTrue(driver.getPageSource().contains("Create username and give password"));
    	WebElement element = driver.findElement(By.name("username"));
    	element.sendKeys(username);
    	element = driver.findElement(By.name("password"));
    	element.sendKeys(password);
    	element = driver.findElement(By.name("passwordConfirmation"));
    	element.sendKeys(passwordConfirmation);
    	element.submit();
    }
}




