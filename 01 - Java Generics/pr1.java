package Day17;
import java.util.ArrayList;
import java.util.List;
abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String getCategory();
}
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
    @Override
    public String getCategory() {
        return "Electronics";
    }
}
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
    @Override
    public String getCategory() {
        return "Groceries";
    }
}
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
    @Override
    public String getCategory() {
        return "Furniture";
    }
}
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
}
public class pr1 {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getCategory() + ": " + item.getName());
        }
    }
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("TV"));
        electronicsStorage.addItem(new Electronics("Refrigerator"));
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Bananas"));
        groceriesStorage.addItem(new Groceries("Milk"));
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Sofa"));
        furnitureStorage.addItem(new Furniture("Bed"));
        System.out.println("---- Electronics ----");
        displayItems(electronicsStorage.getItems());
        System.out.println("---- Groceries ----");
        displayItems(groceriesStorage.getItems());
        System.out.println("---- Furniture ----");
        displayItems(furnitureStorage.getItems());
    }
}