package frm.setpDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AutomationFramework.Pageobjects.LandingPage;
import AutomationFramework.Pageobjects.MyCartPage;
import AutomationFramework.Pageobjects.OrderConfirmationpage;
import AutomationFramework.Pageobjects.Paymentpage;
import AutomationFramework.Pageobjects.ProductCatalogue;
import AutomationFramework.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionimpl extends BaseTest {
	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	public OrderConfirmationpage orderConfirmationpage ;

	@Given("I landed on Ecomm page")
	public void i_landed_on_ecomm_page() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		landingpage = launchapp();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {
		productCatalogue = landingpage.loginapplication(username, password);

	}

	@When("^I add the product (.+) to Cart$")
	public void i_add_the_product_to_cart(String productName) {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> Items = productCatalogue.getProduct();

		productCatalogue.addPrdtocart(productName);
	}

	@When("^Checkout the product (.+)  and submit the order$")
	public void checkout_product_and_submit_the_order(String productName) {
		MyCartPage myCartPage = productCatalogue.goToCart();

		myCartPage.returnaddedProducttocart();

		Boolean match = myCartPage.VerifyProductDisplay(productName);

		Assert.assertTrue(match);

		Paymentpage paymentpage = myCartPage.goToPaymentPage();

		paymentpage.countrySearchandSelection("India");

		 orderConfirmationpage = paymentpage.placeorderbtnclk();

	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_confirmation_page(String string) {
		// Write code here that turns the phrase above into concrete actions
		String Message = orderConfirmationpage.goToOrderConfirmation();

		Assert.assertTrue(Message.equalsIgnoreCase(string));
		teardown();
	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(landingpage.errorMessage(), string);
		teardown();
	}
	
}
