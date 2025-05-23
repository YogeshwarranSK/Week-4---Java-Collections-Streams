package Day22;
import java.util.function.Function;

public class circleAreaCalculator {
    public static void main(String[] args) {
        Function<Double, Double> calculateArea = radius -> Math.PI * radius * radius;

        double radius = 7.0;
        double area = calculateArea.apply(radius);

        System.out.println("Area of circle with radius " + radius + " is: " + area);
    }
}

