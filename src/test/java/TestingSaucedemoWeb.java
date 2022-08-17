import org.junit.Assert;
import org.junit.Test;

public class TestingSaucedemoWeb {

    @Test // טסט מספר 2 ברשימת הוראות לצוות האדום
    public void  SauceDemoTest() {
        SaucedemoWeb sauceDemoWeb1 = new SaucedemoWeb();
        String Url = "https://www.saucedemo.com/";
        sauceDemoWeb1.openSite(Url);
        sauceDemoWeb1.setUsername("standard_user");
        sauceDemoWeb1.signIn();
        sauceDemoWeb1.addToCart("add-to-cart-sauce-labs-bolt-t-shirt");
        sauceDemoWeb1.addToCart("add-to-cart-sauce-labs-bike-light");
        sauceDemoWeb1.removeFromCart("remove-sauce-labs-bolt-t-shirt");
        String actualCheckCardFiled = sauceDemoWeb1.checkCart();
        String expectedCheckCardFiled = "1";
        Assert.assertEquals(actualCheckCardFiled,expectedCheckCardFiled);
        System.out.println("pass");
    }

    @Test // טסט מספר 3 ברשימת הוראות לצוות האדום
    public void LogInUserTest() {
        SaucedemoWeb sauceDemoWeb1 = new SaucedemoWeb();
        String Url = "https://www.saucedemo.com/";
        sauceDemoWeb1.openSite(Url);
        sauceDemoWeb1.setUsername("locked_out_user");
        sauceDemoWeb1.signIn();
        Assert.assertTrue(sauceDemoWeb1.isLoggedIn());
    }

    @Test // טסט פוזיטיב הבודק כישלון כניסה לאתר
    public void LoginFail() {
        SaucedemoWeb sauceDemoWeb1 = new SaucedemoWeb();
        String Url = "https://www.saucedemo.com/";
        sauceDemoWeb1.openSite(Url);
        sauceDemoWeb1.setUsername("locked_out_user");
        sauceDemoWeb1.signIn();
        Assert.assertEquals(sauceDemoWeb1.isLoginError(),true);

    }
}