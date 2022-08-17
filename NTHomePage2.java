package pages;
//
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NTHomePage2 {
	WebDriver driver;
	NTMyAccount account;

	@FindBy(name="username")
	public WebElement userName;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(xpath = "//form[@name='loginform']/button")
	public WebElement submitButton;
	
	String url = "https://nichethyself.com/tourism/home.html";

	public NTHomePage2() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		driver.get(url);
	}

	public NTHomePage2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public NTMyAccount login(String user, String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		submitButton.click();
		return new NTMyAccount(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void tearDown() {
		driver.quit();
	}
public void alertaccept() {
	Alert ac = driver.switchTo().alert();
	ac.accept();
}
}
