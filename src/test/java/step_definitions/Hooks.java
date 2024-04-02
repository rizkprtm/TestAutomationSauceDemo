package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void openBrowser(){

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins");
        String appUrl = "https://www.saucedemo.com/";

        driver = new ChromeDriver(option);
        driver.get(appUrl);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
