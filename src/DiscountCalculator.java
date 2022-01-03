import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {
    public static void manage() {
        hardCodedFunction();
        dynamicCodedFunction();
    }

    private static void hardCodedFunction() {
        int price = 10;
        int firstDiscount = 50;
        int secondDiscount = 30;

        float finalPrice = price - (price * firstDiscount / 100.f);
        finalPrice -= (finalPrice * secondDiscount / 100.f);
        System.out.println("Final price (hardcoded) is : " + finalPrice);
    }

    private static void dynamicCodedFunction() {
        System.out.println("Please enter the price you want to apply discount to");
        int price = Main.scan.nextInt();
        System.out.println("How many discount do you want to apply");
        int nbDiscount = Main.scan.nextInt();

        List<Integer> discounts = new ArrayList<>();
        for (int i = 0; i < nbDiscount; i++) {
            System.out.println("Enter discount number "+(i+1));
            discounts.add(Main.scan.nextInt());
        }

        applyDiscounts(price, discounts);
    }

    private static void applyDiscounts(int price, List<Integer> discounts) {
        Integer prev = null;
        float finalPrice = price;
        //Check that the discounts are in decreasing order
        for (Integer discount : discounts) {
            finalPrice -= (finalPrice*discount)/100.f;
            if (prev == null) {
                prev = discount;
            } else {
                if (discount > prev) {
                    System.out.println("Error, discount must be in decreasing order");
                    return;
                }
                prev = discount;
            }
        }
        System.out.println("Final price (dynamically coded) is : " + finalPrice);
    }
}
