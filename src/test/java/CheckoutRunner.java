import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (tags = "@Checkout",
                features = {"src/test/resources/features"},
                glue = {"step_definitions"},
        plugin = {"pretty" , "html:target/cucumber-Report.html" , "json:target/report.json"})

public class CheckoutRunner extends AbstractTestNGCucumberTests {

}