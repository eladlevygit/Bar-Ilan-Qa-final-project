import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.NoSuchElementException;

public class SaucedemoWeb {

    String Username;
    String Password;
    WebDriver driver;

    public SaucedemoWeb() {
        System.setProperty("webDriver.chrome.driver", "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programsch\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();

        // set initial data
        this.Password = "secret_sauce";
    }

    public void openSite(String Url) {
        this.driver.get("https://www.saucedemo.com/");
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public void signIn() {
        WebElement usernameField = this.driver.findElement(By.id("user-name"));
        WebElement passwordField = this.driver.findElement(By.id("password"));

        usernameField.sendKeys(this.Username);
        passwordField.sendKeys(this.Password);

        WebElement loginButton = this.driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
    }

    public void addToCart(String id) {
        WebElement addToCartField = this.driver.findElement(By.id(id));
        addToCartField.click();
    }

    public void removeFromCart(String id) {
        WebElement removeFromCartField = this.driver.findElement(By.id(id));
        removeFromCartField.click();
    }

   public String checkCart() {
       WebElement cartBadge = this.driver.findElement(By.className("shopping_cart_badge"));
       String text = cartBadge.getText();
       return text;
    }

    public boolean isLoginError() {
        try {
           this.driver.findElement(By.className("error-message-container"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoggedIn() {
        try {
            this.driver.findElement(By.className("error-message-container error"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}




