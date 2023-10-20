package framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverProvider {

    private static final String BROWSER = "Chrome";
    private static WebDriver driverInstance;

    public static WebDriver getDriver(){
        if(driverInstance==null){
            driverInstance = selectDriver();
        }
        return driverInstance;
    }

    public static void quitDriver(){
        if(driverInstance!=null) {
            driverInstance.quit();
            driverInstance=null;
        }
    }

    private static WebDriver selectDriver(){
        WebDriver driver;

        switch (BROWSER){
            case "Firefox":
                System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\macie\\Downloads\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\macie\\Downloads\\msedgedriver.exe");
                EdgeOptions edgeOtions = new EdgeOptions();
                edgeOtions.addArguments("--remote-allow-origins=*");
                edgeOtions.addArguments("--allowed-ips=*");
                edgeOtions.addArguments("--whitelisted-ips==*");
                driver = new EdgeDriver(edgeOtions);
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\macie\\Downloads\\chromedriver-win64\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--allowed-ips=*");
                chromeOptions.addArguments("--whitelisted-ips==*");
                driver = new ChromeDriver(chromeOptions);
        }

        return driver;

    }

}


