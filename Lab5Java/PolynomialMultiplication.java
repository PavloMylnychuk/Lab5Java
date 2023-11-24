import java.util.ArrayList;
import java.util.List;

public class PolynomialMultiplication {

    public static List<Double> multiplyPolynomials(List<Double> poly1, List<Double> poly2) {
        int degree1 = poly1.size() - 1;
        int degree2 = poly2.size() - 1;
        int resultDegree = degree1 + degree2;
        List<Double> result = new ArrayList<>(resultDegree + 1);

        for (int i = 0; i <= resultDegree; i++) {
            result.add(0.0);
        }

        for (int i = 0; i <= degree1; i++) {
            for (int j = 0; j <= degree2; j++) {
                result.set(i + j, result.get(i + j) + poly1.get(i) * poly2.get(j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Double> polynomial1 = new ArrayList<>();
        polynomial1.add(3.0); // x^0
        polynomial1.add(2.0); // x^1
        polynomial1.add(5.0); // x^2

        List<Double> polynomial2 = new ArrayList<>();
        polynomial2.add(1.0); // x^0
        polynomial2.add(4.0); // x^1

        List<Double> result = multiplyPolynomials(polynomial1, polynomial2);

        System.out.println("Результат множення многочленів: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%.1fx^%d ", result.get(i), i);
            if (i != result.size() - 1) {
                System.out.print("+ ");
            }
        }
    }
}
