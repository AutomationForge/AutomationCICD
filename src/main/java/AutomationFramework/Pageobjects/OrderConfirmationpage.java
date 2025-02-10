package AutomationFramework.Pageobjects;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 2760f21 (Handled Exception code)
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

=======
>>>>>>> 2760f21 (Handled Exception code)
import AutomationFramework.AbstractComponents.AbstractComponent;

public class OrderConfirmationpage extends AbstractComponent {
	public WebDriver driver;

	public OrderConfirmationpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	// Page factory

	@FindBy(css = ".hero-primary")
	WebElement Ordercomfirmsg;

	By OrderConfirmPagetoappear = By.cssSelector(".hero-primary");

	public String goToOrderConfirmation() {

		waitForElementToAppear(OrderConfirmPagetoappear);
		String Message = Ordercomfirmsg.getText();
		return Message;

	}
	

}