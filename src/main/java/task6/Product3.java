package task6;

public class Product3 extends Product2 {
    protected int weight;

    public Product3(String name, int price, String color, int weight) {
        super(name, price, color);
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product3{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", color='").append(color).append('\'');
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
