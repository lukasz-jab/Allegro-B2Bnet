package allegro.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticleHelper {

    private WebDriver wd;

    public ArticleHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void selectArticleColor(String color) {
        wd.findElement(By.xpath("//div[@class='opbox-listing-filters']//span[.='" + color + "']")).click();
    }

    public void submitSearchBar() {
        wd.findElement(By.cssSelector("div[data-box-name='allegro.metrumHeader'] button[type=submit]")).click();
    }

    public void fillSearchBar() {
        wd.findElement(By.cssSelector("div[data-box-name='allegro.metrumHeader'] input[type=search]"))
                .sendKeys("Iphone 11");
    }
}
