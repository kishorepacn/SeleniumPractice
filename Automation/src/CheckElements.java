import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckElements {
	static ChromeDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Automation/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		WebElement Maria=driver.findElement(By.xpath("//*[@id=\"contactList\"]/tbody/tr[2]/td[1]/input"));
		Maria.click();
			
		}
	}


