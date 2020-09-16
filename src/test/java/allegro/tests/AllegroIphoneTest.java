package allegro.tests;

import allegro.model.ArticleData;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class AllegroIphoneTest extends TestBase {

    @Test
    public void testAllegroIphone() {

        app.article().fillSearchBar("Iphone 11");
        app.article().submitSearch();
        app.article().selectColor("czarny");

        List<ArticleData> articlesFirstSite = app.article().list();

        System.out.println("Ilość czarnych Iphonów11 na pierwszej stronie wynosi: " + articlesFirstSite.size());

        ArticleData maxPrice =
                articlesFirstSite.stream().max((o1, o2) -> o1.priceToCalc().compareTo(o2.priceToCalc())).get();
        System.out.println("Największa cena na liście to: " + maxPrice.priceToCalc() + "zł");

        System.out.println("Największa cena na liście + 23% wynosi: " + (maxPrice.priceToCalc())
                .multiply(new BigDecimal("1.23")).setScale(2) + "zł");
    }


}
