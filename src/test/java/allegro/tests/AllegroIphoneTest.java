package allegro.tests;

import allegro.model.ArticleData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AllegroIphoneTest extends TestBase {

    @Test
    public void testIphoneAllegro() {

        app.getArticleHelper().fillSearchBar();
        app.getArticleHelper().submitSearchBar();
        app.getArticleHelper().selectArticleColor("czarny");

        List<WebElement> articles = new ArrayList<>();
        articles = app.wd.findElements(By.cssSelector("div#opbox-listing--base article"));

        List<ArticleData> articlesFirstSite = new ArrayList<>();
        for (WebElement e : articles) {
            e.findElement(By.cssSelector("span[class='_1svub _lf05o']")).getText();
            articlesFirstSite.add(new ArticleData().withPrice(e.findElement(By.cssSelector("span[class='_1svub _lf05o']")).getText()
                    .replaceAll("[\\,]", "\\.").replaceAll("[zł]", "")
                    .replaceAll("\\s", "")));

        }

        System.out.println("Ilość czarnych Iphonów11 na pierwszej stronie wynosi: " + articlesFirstSite.size());

        ArticleData maxPrice =
                articlesFirstSite.stream().max((o1, o2) -> o1.getPriceToCalculations().compareTo(o2.getPriceToCalculations())).get();
        System.out.println("Największa cena na liście to: " + maxPrice.getPriceToCalculations() + "zł");

        System.out.println("Największa cena na liście + 23% wynosi: " + (maxPrice.getPriceToCalculations())
                .multiply(new BigDecimal("1.23")).setScale(2) + "zł");
    }

}
