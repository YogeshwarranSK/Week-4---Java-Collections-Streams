package Day18;
import java.util.*;

public class ShoppingCartSystem {
    static class ShoppingCartManager {
        HashMap<String, Double> productPrices = new HashMap<>();
        LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();
        TreeMap<Double, List<String>> sortedItemsByPrice = new TreeMap<>();
        public void addProduct(String productName, double price) {
            productPrices.put(productName, price);
        }
        public void addToCart(String productName, int quantity) {
            if (!productPrices.containsKey(productName)) {
                System.out.println("Product not found.");
                return;
            }
            cartItems.put(productName, cartItems.getOrDefault(productName, 0) +
                    quantity);
        }
        public void displayCart() {
            System.out.println("Items in Cart (LinkedHashMap):");
            for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
                System.out.println(entry.getKey() + " - Quantity: " +
                        entry.getValue() + " - Price: $" + productPrices.get(entry.getKey()));
            }
        }
        public void displaySortedItemsByPrice() {
            System.out.println("\nItems Sorted by Price (TreeMap):");
            sortedItemsByPrice.clear();
            for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
                double price = productPrices.get(entry.getKey());
                for (int i = 0; i < entry.getValue(); i++) {
                    sortedItemsByPrice.putIfAbsent(price, new ArrayList<>());
                    sortedItemsByPrice.get(price).add(entry.getKey());
                }
            }
            for (Map.Entry<Double, List<String>> entry :
                    sortedItemsByPrice.entrySet()) {
                System.out.println("Price: $" + entry.getKey() + " -> " +
                        entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        ShoppingCartManager manager = new ShoppingCartManager();
        manager.addProduct("Laptop", 999.99);
        manager.addProduct("Phone", 699.99);
        manager.addProduct("Headphones", 199.99);
        manager.addProduct("Mouse", 49.99);
        manager.addToCart("Laptop", 1);
        manager.addToCart("Phone", 2);
        manager.addToCart("Mouse", 1);
        manager.displayCart();
        manager.displaySortedItemsByPrice();
    }
}