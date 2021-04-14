package task1;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1 == null || o2 == null) return 0;

        int priceDiff = o2.getPrice() - o1.getPrice();

        if (priceDiff == 0) {
            return o1.getName().compareTo(o2.getName());
        }

        return priceDiff;
    }
}
