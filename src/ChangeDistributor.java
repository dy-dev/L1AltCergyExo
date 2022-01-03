import java.util.Random;

public class ChangeDistributor {
    static int[] change = {50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
    static float priceToPay;

    public static void giveBackChange() {
        int nb20Bills = definePriceAndGetBuyerBills();
        calculateChange(nb20Bills);
    }

    private static int definePriceAndGetBuyerBills() {
        Random rand = new Random();
        priceToPay = 100.f * rand.nextFloat() + 50.f;
        Integer nb20Bills = null;
        do {
            if (nb20Bills == null)
                System.out.println("Price to pay : " + priceToPay);
            else
                System.out.println("Please give enough bills to pay the price");
            nb20Bills = Main.scan.nextInt();
        } while (nb20Bills * 20 < priceToPay);
        return nb20Bills;
    }

    private static void calculateChange(int nb20Bills) {
        //Converts the value given by user in cents
        int moneyInCents = (int) (nb20Bills * 2000 - 100 * priceToPay);

        for (int value : change) {
            if (moneyInCents / value > 0) {
                int val = (int) (value / 100.f);
                String type = " bills";
                if (value / 100.f < 5) {
                    if (value / 100.f >= 1)
                        type = " euro coins";
                    else {
                        type = " cents coins";
                        val = value;
                    }
                }
                System.out.println("Number of " + val + type + " : " + moneyInCents / value);
                moneyInCents = moneyInCents % value;
            }
        }
    }
}
