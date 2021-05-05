package task6;

public class Product2 extends Product1 {
    protected String color;

    public Product2(String name, int price, String color) {
        super(name, price);
        this.color = color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product2{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
