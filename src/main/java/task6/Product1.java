package task6;

public class Product1 {
    protected String name;
    protected int price;

    public Product1(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product1{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
