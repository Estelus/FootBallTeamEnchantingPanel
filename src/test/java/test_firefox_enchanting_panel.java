import framework.DriverProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;




public class test_firefox_enchanting_panel {
    WebDriver driver;

    @BeforeEach
    public void SetUp(){
        driver = DriverProvider.getDriver();



        System.out.println("Opening Firefox browser.");
        System.setProperty("webdriver.gecko,driver", "C:\\Users\\macie\\Downloads\\geckodriver.exe");


    }
    @Test
    public void testPageTitle() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://footballteamgame.com/pl/");
        String title = driver.getTitle();
        assertEquals("Menad\u017Cer pi\u0142karski online - Pi\u0142karska gra online - graj w FootballTeam", title);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));;

        driver.quit();
    }
    @Test
    public void EnteringPanelEnchanting(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://footballteamgame.com/pl/");
        //act - Get to the main login page. Finding drop down to log in account. Clicking on it. Provide credential to log into the web service
        driver.findElement(By.cssSelector("span.like-link.hidden")).click();
        driver.findElement(By.cssSelector("div.header")).click();
        driver.findElement(By.cssSelector("[type=email]")).sendKeys("maciej.m1993@gmail.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("m5rMASt8pKkChmj");
        driver.findElement(By.cssSelector("button.isSkewed div[data-v-d2acbfea]")).click();
        //assert - assertion to prove that the user successful logged into the website
        String actualTitle = driver.getTitle();
        assertEquals("Menad\u017Cer pi\u0142karski online - Pi\u0142karska gra online - graj w FootballTeam", actualTitle, "page Title does not match the expected title" );
        //act - click and transfer the user to the dashboard panel
        driver.findElement(By.cssSelector("div.header__menu")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("div.header__menu")).click();
        //assert - assertion to make sure the user entered the dashboard panel
        String url_of_dashboard_panel = driver.getCurrentUrl();
        assertEquals("https://pl.footballteamgame.com/dashboard", url_of_dashboard_panel, "page Title does not match the expected title");
        //act - the user navigate to the character panel
        driver.findElement(By.cssSelector("body > div:nth-child(2) > div > aside > ul > li:nth-child(2) > a > div.icons-container-wrapper")).click();
        //assert - make sure that the user changed the panel
        String title_of_character_panel = driver.getTitle();
        assertEquals("Dashboard | FootballTeam - Pi\u0142karska gra online", title_of_character_panel, "title of character panel does not match" );
        //act - the user click on dropdown list box
        driver.findElement(By.cssSelector("div > nav > ul > li:nth-child(3) > a > span")).click();
        driver.findElement(By.cssSelector("div > nav > ul > li:nth-child(3) > ul > li:nth-child(3) > a > span > div > span")).click();
        //assert
        String url_of_enchanting_panel = driver.getCurrentUrl();
        assertEquals("https://pl.footballteamgame.com/character", url_of_enchanting_panel, "Url of enchanting panel does not match");
        driver.quit();
    }


}

