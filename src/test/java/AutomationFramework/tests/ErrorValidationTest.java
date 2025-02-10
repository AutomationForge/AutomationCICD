package AutomationFramework.tests;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationFramework.Pageobjects.LandingPage;
import AutomationFramework.Pageobjects.MyCartPage;
import AutomationFramework.Pageobjects.OrderConfirmationpage;
import AutomationFramework.Pageobjects.Paymentpage;
import AutomationFramework.Pageobjects.ProductCatalogue;
import AutomationFramework.TestComponents.BaseTest;
import AutomationFramework.TestComponents.RetryAnalysis;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(ErrorValidationTest.class);

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = RetryAnalysis.class)
	public void incorrectCreds() throws IOException {
		
		
		logger.info("** Start incorrectCreds Test case **");
		
		try {

		String prdname = "ZARA COAT 3";
		
		logger.info("** User opened App and starts entering User and pass **");

		ProductCatalogue productCatalogue = landingpage.loginapplication("Skip923@gmail.com", "Test1234");
		
		logger.info("** User Entered Incorrect Username and Pass**");

		logger.info("** Validating expected results **");
		
		Assert.assertEquals(landingpage.errorMessage(), "Incorrect email or password.");
		
		logger.info("** User and pass validation message is shown **");
		
		}
		
		catch(Throwable e){
		    logger.error("Test failed due to: " + e.getMessage());  // Logs the failure reason
		    logger.debug("Stack trace: ", e); // Logs full stack trace for debugging
		    Assert.fail(e.getMessage()); // Pass the error message to Assert.fail()
		}
		
		logger.info("** Finished incorrectCreds Test case **");
	}

	@Test
	public void ProductErrorValidation() throws IOException {

<<<<<<< HEAD
		String prdname = "qwerty";
=======
		String prdname = "LG Refrigerator";
>>>>>>> 2760f21 (Handled Exception code)

		ProductCatalogue productCatalogue = landingpage.loginapplication("Skip1234@gmail.com", "Test1234");

		logger.info("** User Entered correct Username and Pass**");

		List<WebElement> Items = productCatalogue.getProduct();

		productCatalogue.addPrdtocart(prdname);

		logger.info("** Product is added to cart**");

		MyCartPage myCartPage = productCatalogue.goToCart();
		
		logger.info("** User is moved to cart page Successfully**");

		myCartPage.returnaddedProducttocart();

		logger.info("** User Verify Product is Displayed on cart**");

<<<<<<< HEAD
		Boolean match = myCartPage.VerifyProductDisplay("qwerty33");
=======
		Boolean match = myCartPage.VerifyProductDisplay("LG Refrigerator33");
>>>>>>> 2760f21 (Handled Exception code)

		logger.info("** Validating expected product **");

		Assert.assertFalse(match);

		logger.info("** Product is Displayed on cart page**");

	}

}
