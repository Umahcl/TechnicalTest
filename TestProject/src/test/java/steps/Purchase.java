package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase {

	public static ChromeDriver driver;

	@Given("Launch the browser and Load URL")
	public void launch_the_browser_and_Load_URL() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com");
	}

	@When("The User Clicks Signin")
	public void the_User_Clicks_Signin() {
		driver.findElementByLinkText("Sign in").click();
	}

	@When("Enter the Username as \"(.*?)\" and password as \"(.*?)\" and signin")
	public void enter_the_Credentials_and_Signin(String userName, String password) {
		driver.findElementById("email").sendKeys(userName);
		driver.findElementById("passwd").sendKeys(password);
		driver.findElementByXPath("(//button[@type='submit']//span)[3]").click();
	}

	@Then("Verify the Page is Loaded")
	public void verify_the_Page_is_Loaded() {
		String page = driver.findElementByXPath("//img[@class='logo img-responsive']").getAttribute("alt");
		if (page.contains("My Store")) {
			System.out.println("The page is verified");
		}
	}

	@When("User Clicks TShirt")
	public void user_Clicks_TShirt() {
		driver.findElementByXPath("(//a[@title='T-shirts'])[2]").click();
	}

	@When("User Clicks AddtoCart")
	public void user_Clicks_AddtoCart() {
		// Scroll down
		WebElement item = driver.findElementByXPath("//img[@alt='Faded Short Sleeve T-shirts']");
		int y = item.getLocation().getY();

		driver.executeScript("scroll(0," + y + ");");

		// move to Shirts
		Actions builder = new Actions(driver); // what we are actually doing here
		builder.moveToElement(item).perform();

		// Click AddtoCart
		driver.findElementByXPath("//span[text()='Add to cart']").click();

	}

	@When("User Clicks Proceed to Checkout in Cart")
	public void user_Clicks_Proceed_to_Checkout() {
		driver.findElementByXPath("//a[@title='Proceed to checkout']//span[1]").click();
	}

	@Then("Verify Product displayed in Order Summary")
	public void verify_Product_displayed_in_Order_Summary() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();

		String item = driver.findElementByXPath("((//p[@class='product-name'])[2])/a").getText();
		if (item.contains("Faded Short Sleeve T-shirts")) {
			System.out.println("The item is verified in the Order Summary");
		}
	}

	@When("User Clicks Proceeds to Checkout in Shopping Cart Summary")
	@And("User Clicks Proceed to Checkout in Address Page")
	public void user_Clicks_Proceed_to_Checkout_in_Summary() {
		WebElement item = driver.findElementByXPath("//span[text()='Proceed to checkout']");
		int y = item.getLocation().getY();

		driver.executeScript("scroll(0," + y + ");");
		item.click();
	}

	@When("User agrees to the terms of Service")
	public void user_agrees_to_the_terms_of_Service() {
		WebElement item = driver.findElementById("cgv");
		int y = item.getLocation().getY();

		driver.executeScript("scroll(0," + y + ");");
		item.click();
	}

	@When("User Clicks Proceed to Checkout in Shipping")
	public void user_Clicks_Proceed_to_Checkout_in_Shipping() {
		driver.findElementByXPath("(//button[@type='submit']/span)[2]").click();
	}

	@When("User selects the Payment method")
	public void user_selects_the_Payment_method() {
		WebElement paymentmethod = driver.findElementByClassName("bankwire");
		int y = paymentmethod.getLocation().getY();

		driver.executeScript("scroll(0," + y + ");");
		paymentmethod.click();
	}

	@When("User Confirms the Order")
	public void user_Confirms_the_Order() {
		WebElement item = driver.findElementByXPath("//span[text()='I confirm my order']");
		int y = item.getLocation().getY();

		driver.executeScript("scroll(0," + y + ");");
		item.click();
	}

	@When("User Clicks Back to Orders")
	public void user_Clicks_Back_to_Order() {
		WebElement backtoorder = driver.findElementByXPath("//a[@title='Back to orders']");
		int y = backtoorder.getLocation().getY();

		driver.executeScript("scroll(0," + y + ");");
		backtoorder.click();
	}

	@Then("Verify Product is displayed in Order history")
	public void verify_Product_displayed_in_Order_history() {
		// Click the link
		WebElement firstLink = driver.findElementByXPath("//table[@id='order-list']/tbody[1]/tr[1]/td[1]/a[1]");
		int y = firstLink.getLocation().getY();

		driver.executeScript("scroll(0," + y + ");");
		firstLink.click();

		// Verify the Product
		WebElement product = driver.findElementByXPath(
				"(//table[contains(@class,'table table-bordered')]/following::table)[2]/tbody[1]/tr[1]/td[2]/label[1]");
		String prodName = product.getText();
		if (prodName.contains("Faded Short Sleeve T-shirts")) {
			System.out.println("The Order is verified in the Order History");
		}

		driver.close();
	}

	@When("User selects My Personal Information")
	public void user_selects_My_Personal_Information() {
		WebElement personalInformation = driver.findElementByXPath("//span[text()='My personal information']");
		int y = personalInformation.getLocation().getY();

		driver.executeScript("scroll(0," + y + ");");
		personalInformation.click();
	}

	@When("User Updates the First Name(.*)")
	public void user_updates_firstname(String Name) {
		WebElement fName = driver.findElementById("firstname");
		fName.clear();
		fName.sendKeys(Name);

		driver.close();
	}

}
