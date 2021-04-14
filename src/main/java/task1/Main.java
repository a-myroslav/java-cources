package task1;

import java.util.*;

class Main {

    public static void main(String[] args) {

        System.out.println("Linked list of products");

        List<Product> productList = new LinkedList<>();

        productList.add(new Product());
        productList.add(new Product());
        productList.add(null);

        productList.add(new Product("Water", 10));
        productList.add(new Product("Bread", 20));
        productList.add(new Product("Juice", 8));
        productList.add(new Product("Rice", 32));
        productList.add(new Product("Whisky", 40));
        productList.add(new Product("Beer", 10));

        Product sameProduct1 = new Product("Shit Whisky", 15);
        Product sameProduct2 = new Product("Shit Beer", 3);

        for (int i = 0; i < 5; i++) {
            productList.add(sameProduct1);
            productList.add(sameProduct2);
        }

        // remove empty elements
        productList.removeIf(Objects::isNull);

        /*
         * OPTION 1
         * remove duplicates with HashSet then sort collection
         */

//        Set<Product> productSet = new HashSet<>(productList);
//        productList.clear();
//        productList.addAll(productSet);
//        productList.sort(new ProductComparator());

        /*
         * OPTION 2
         * remove duplicates with a brute force
         */

//        productList.sort(new ProductComparator());
//        for (int i = 0; i < productList.size() - 1; ) {
//            if (productList.get(i).equals(productList.get(i + 1))) {
//                productList.remove(i + 1);
//            } else {
//                i++;
//            }
//        }


        /*
         * OPTION 3
         * remove duplicates with a ListIterator
         */

        productList.sort(new ProductComparator());
        ListIterator<Product> listIterator = productList.listIterator();

        while (listIterator.hasNext()) {
            Product currentProduct = listIterator.next();
            if (listIterator.hasNext()) {
                Product nextProduct = listIterator.next();

                if (currentProduct.equals(nextProduct)) {
                    listIterator.remove();
                }
                listIterator.previous();
            }
        }

        System.out.println("----------------------------------");
        System.out.println("RESULT: count = " + productList.size());

        for (Product product : productList) {
            System.out.println(product.toString());
        }

    }
}
