

	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	public class Sample {
	
			public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\Selenium Testing\\Chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://the-internet.herokuapp.com/");
			driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
			
			//Set of Window Id retrieval
			Set<String> unique = driver.getWindowHandles();
			Iterator<String> iter = unique.iterator();
			String parentid = iter.next();
			String childid = iter.next();
			
			
			// Switch to Child
			driver.switchTo().window(childid);
			System.out.println(driver.getTitle());

			// Back to Parent Window
			driver.switchTo().window(parentid);
			System.out.println(driver.getTitle());

		}

	}


