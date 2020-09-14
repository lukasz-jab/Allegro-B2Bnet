package allegro.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.cssSelector;

public class SessionHelper {

    private WebDriver wd;
    private WebDriverWait wait;


    public SessionHelper(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(wd, 10);
    }

    public void drogiKlienciePopUp() {
        if (isElementPresent(cssSelector("button[data-role=close-and-accept-consent]"))) ;
        {
            wait.until(wd -> wd.findElement(By.cssSelector("button[data-role=close-and-accept-consent]"))).click();
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
