package task6;

public class Main {
    public static void main(String[] args) {
        Product1 p1 = new Product1("p1", 10);
        Product2 p2 = new Product2("p2", 5, "grey");
        Product3 p3 = new Product3("p2", 5, "grey", 2);

        Shelf<Product1> sh = new Shelf<>();

        sh.addProduct(p1);
        sh.addProduct(p2);
        sh.addProduct(p3);

        sh.showProducts();
    }
}
