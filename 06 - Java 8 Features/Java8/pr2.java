package Day22.Java8;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class pr2 {

    public static class Sale {
         String productId;
         int quantity;
         double price;

        public Sale(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }
    }

    public static class ProductSales {
        private String productId;
        private double totalRevenue;

        public ProductSales(String productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }

        public String getProductId() { return productId; }
        public double getTotalRevenue() { return totalRevenue; }

        @Override
        public String toString() {
            return productId + ": $" + totalRevenue;
        }
    }

    public static void analyzeSales(List<Sale> sales) {
        List<ProductSales> topProducts = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .collect(groupingBy(Sale::getProductId,
                        summingDouble(s -> s.getQuantity() * s.getPrice())))
                .entrySet().stream()
                .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
                .limit(5)
                .collect(toList());

        System.out.println("Top 5 Products by Revenue:");
        topProducts.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 15, 10.0),
                new Sale("P2", 5, 20.0),
                new Sale("P1", 8, 10.0),
                new Sale("P3", 20, 5.0),
                new Sale("P4", 12, 25.0),
                new Sale("P5", 11, 30.0),
                new Sale("P6", 50, 1.0),
                new Sale("P7", 9, 100.0),
                new Sale("P8", 13, 8.0),
                new Sale("P9", 18, 12.0)
        );

        analyzeSales(sales);
    }
}

