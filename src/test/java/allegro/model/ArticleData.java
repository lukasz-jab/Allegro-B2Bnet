package allegro.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ArticleData {

    private String price;
    private BigDecimal priceToCalculations;

    public ArticleData withPrice(String price) {
        this.price = price;
        return this;
    }

    public BigDecimal priceToCalc() {
        return priceToCalculations = new BigDecimal(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleData that = (ArticleData) o;
        return Objects.equals(price, that.price) &&
                Objects.equals(priceToCalculations, that.priceToCalculations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, priceToCalculations);
    }

}
