package allegro.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver wd;

    private ArticleHelper articleHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals("firefox")) {
            wd = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            wd = new ChromeDriver();
        }

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        articleHelper = new ArticleHelper(wd);
        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);

        wd.get("https://allegro.pl/");
        sessionHelper.drogiKlienciePopUp();
    }

    public void stop() {
        wd.quit();
        wd = null;
    }

    public ArticleHelper getArticleHelper() {
        return articleHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
