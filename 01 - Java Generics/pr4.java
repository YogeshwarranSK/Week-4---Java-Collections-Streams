package Day17;
import java.util.*;
interface MealPlan {
    String getMealType();
    List<String> getMeals();
}
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
    public List<String> getMeals() {
        return Arrays.asList("Paneer Curry", "Vegetable Rice", "Dal Tadka");
    }
}
class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
    public List<String> getMeals() {
        return Arrays.asList("Paneer Stir Fry", "Quinoa Salad", "Rajma Chawal");
    }
}
class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }
    public List<String> getMeals() {
        return Arrays.asList("Grilled Chicken", "Veg Salad", "Egg Bhurji");
    }
}
class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }
    public List<String> getMeals() {
        return Arrays.asList("Protein Shake", "Grilled Fish", "Boiled Eggs");
    }
}
class Meal<T extends MealPlan> {
    private T mealPlan;
    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }
    public void showPlan() {
        System.out.println("Meal Type: " + mealPlan.getMealType());
        System.out.println("Meals:");
        for (String item : mealPlan.getMeals()) {
            System.out.println("- " + item);
        }
    }
}
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generatePlan(T mealPlan) {
        System.out.println("Generating personalized meal plan for: " +
                mealPlan.getMealType());
        return new Meal<>(mealPlan);
    }
}
public class pr4 {
    public static void main(String[] args) {
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal protein = new HighProteinMeal();
        Meal<?> m1 = MealPlanGenerator.generatePlan(veg);
        m1.showPlan();
        System.out.println();
        Meal<?> m2 = MealPlanGenerator.generatePlan(keto);
        m2.showPlan();
    }
}
