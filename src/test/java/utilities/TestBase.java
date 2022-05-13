package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	public WebDriver driver;
	public WebDriver webDriverManager() throws IOException {
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		
		if(driver == null) {
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver","D:\\FireFoxDriver2022\\geckodriver.exe"); 
				driver = new FirefoxDriver(); 
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("IE")) 
			{
				System.setProperty("webdriver.ie.driver", "D:\\IEDriver2022\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		}
		
		return driver;
	}

}
