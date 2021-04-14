package task1;

import java.util.Objects;

public class Product {
    private String name;
    private int price;

    Product() {
        name = "";
        price = 0;
    }

    Product(Product product) {
        name = product.getName();
        price = product.getPrice();
    }

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getPrice() == product.getPrice() && getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Product: {name: \"" + name + "\", price: " + price + "}";
    }

}
