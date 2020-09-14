package allegro.appmanager;

import allegro.model.ArticleData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void fillSearchBar(String article) {
        wd.findElement(By.cssSelector("div[data-box-name='allegro.metrumHeader'] input[type=search]"))
                .sendKeys(article);
    }

    public List<ArticleData> getArticlesList() {
        List<WebElement> articles = new ArrayList<>();
        articles = wd.findElements(By.cssSelector("div#opbox-listing--base article"));

        List<ArticleData> articlesFirstSite = new ArrayList<>();
        for (WebElement e : articles) {
            articlesFirstSite.add(new ArticleData().withPrice(e.findElement(By.cssSelector("span[class='_1svub _lf05o']")).getText()
                    .replaceAll("[\\,]", "\\.").replaceAll("[zł]", "")
                    .replaceAll("\\s", "")));

        }
        return articlesFirstSite;
    }

}
