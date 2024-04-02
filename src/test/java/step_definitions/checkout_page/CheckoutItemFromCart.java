package step_definitions.checkout_page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import step_definitions.Hooks;

public class CheckoutItemFromCart {
    private final WebDriver driver = Hooks.driver;

    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("User navigating to cart page")
    public void navigateToCartPage() {
        checkoutPage.clickCart();
    }

    @Then("User already on {string} as cart page")
    public void verifyOnCartPage(String msg){
        Assert.assertEquals( msg, checkoutPage.verifyOnCartPage());
    }

    @And("User navigating to checkout page")
    public void navigateToCheckoutPage() {
        checkoutPage.clickCheckout();
    }

    @And("User filling {string} as firstName, {string} as lastName and {string} as postal code")
    public void inputCredentials(String firstname, String lastname, String code) {
        checkoutPage.setFirstName(firstname);
        checkoutPage.setLastName(lastname);
        checkoutPage.setPostalCode(code);
    }

    @And("User navigating to checkout overview page")
    public void navigateToCheckoutOverview() {
        checkoutPage.clickContinue();
    }

    @And("User verifying item total and tax price")
    public void verifyingPrice(){
        Float totalItemPrice = (Float.parseFloat(checkoutPage.getItemPrice().substring(13)) + Float.parseFloat(checkoutPage.getTaxPrice().substring(6)));

        Float totalPrice = Float.parseFloat(checkoutPage.getTotalPrice().substring(8));

        Assert.assertEquals(totalItemPrice, totalPrice);
    }

    @Then("User navigating to checkout complete page")
    public void clickFinish() {
        checkoutPage.clickFinish();
    }

}
