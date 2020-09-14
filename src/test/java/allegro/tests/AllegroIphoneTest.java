package allegro.tests;

import allegro.model.ArticleData;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class AllegroIphoneTest extends TestBase {

    @Test
    public void testIphoneAllegro() {

        app.getArticleHelper().fillSearchBar("Iphone 11");
        app.getArticleHelper().submitSearchBar();
        app.getArticleHelper().selectArticleColor("czarny");

        List<ArticleData> articlesFirstSite = app.getArticleHelper().getArticlesList();

        System.out.println("Ilość czarnych Iphonów11 na pierwszej stronie wynosi: " + articlesFirstSite.size());

        ArticleData maxPrice =
                articlesFirstSite.stream().max((o1, o2) -> o1.getPriceToCalculations().compareTo(o2.getPriceToCalculations())).get();
        System.out.println("Największa cena na liście to: " + maxPrice.getPriceToCalculations() + "zł");

        System.out.println("Największa cena na liście + 23% wynosi: " + (maxPrice.getPriceToCalculations())
                .multiply(new BigDecimal("1.23")).setScale(2) + "zł");
    }


}
