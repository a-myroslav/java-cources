package task6;

import java.util.ArrayList;

public class Shelf<T extends Product1> {

    private ArrayList<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void showProducts() {
        for(T product : products) {
            printProductInfo(product);
        }
    }

    private void printProductInfo(T product) {
        System.out.println(product.toString());
    }

}
