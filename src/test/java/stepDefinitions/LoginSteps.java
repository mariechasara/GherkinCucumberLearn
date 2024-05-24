package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import runners.TestRunner;

public class LoginSteps {
    WebDriver driver = TestRunner.driver;

    @Given("the user is on the login page")
    public void the_user_is_on_login_page(){
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials(){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("the user should be redirected to the inventory page")
    public void the_user_should_be_redirected_to_the_inventory_page(){
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials(){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("invalid_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("invalid");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed(){
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@data-test,'error')] ")).isDisplayed());
    }




}
