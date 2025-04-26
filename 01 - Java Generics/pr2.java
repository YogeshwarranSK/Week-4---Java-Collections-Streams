package Day17;
import java.util.*;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println(category.getCategoryName() + " - " + name + ": $" + price);
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double original = product.getPrice();
        double discounted = original - (original * percentage / 100);
        product.setPrice(discounted);
        System.out.println("Discount applied to " + product.getName() + ": New price = $" + discounted);
    }
}

public class pr2 {
    public static void main(String[] args) {
        List<Product<? extends Category>> catalog = new ArrayList<>();
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 25.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 600.0, new GadgetCategory());
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        System.out.println("---- Catalog Before Discount ----");
        for (Product<? extends Category> item : catalog) {
            item.display();
        }
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 15);
        DiscountUtil.applyDiscount(phone, 5);
        System.out.println("\n---- Catalog After Discount ----");
        for (Product<? extends Category> item : catalog) {
            item.display();
        }
    }
}
