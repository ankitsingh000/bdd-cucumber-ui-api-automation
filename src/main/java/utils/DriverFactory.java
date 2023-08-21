package utils;

import java.net.InetAddress;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjects.AmazonDashboardPage;
import pageObjects.LoginPage;

public class DriverFactory {
	public static WebDriver driver;
	public static void initWebDriver() {
		try {
			String browser = ReadConfigFile.readConfig("browser");
			String webSiteUrl = ReadConfigFile.readConfig("URL");
			InetAddress localhost = InetAddress.getLocalHost();
			String ipAddress = localhost.getHostAddress();
			// Construct the URL using the IP address
			String protocol = "http";  // or "https" if applicable
			int port = 4444;  // Replace with the desired port number
			String path = "/wd/hub";  // Replace with the desired path
			URL url = new URL(protocol, ipAddress, port, path);
			//URL url = new URL("http://192.168.0.101:4444/wd/hub");
			System.out.println("Constructed URL: " + url);
			switch (browser.toLowerCase()) {
			case "chrome":
				//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
				WebDriverManager.chromedriver().setup();

				//WebDriverManager.chromedriver().version("116.0.5845.96").setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--no-sandbox");
				options.addArguments("--remote-allow-origins=*");

				//options.setBinary("/usr/bin/google-chrome-stable");
				//options.addArguments("--window-size=1366,768");
				//options.setBrowserVersion("116.0.5845.96");

				//driver=new ChromeDriver(options);
				driver=new RemoteWebDriver(url, options);
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				//capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(webSiteUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void tearDownDrivers() {
		if (driver != null) {
			driver.quit();
		}
	}
}
