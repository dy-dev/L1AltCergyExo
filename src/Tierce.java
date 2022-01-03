import java.math.BigInteger;

public class Tierce {
    static int bruteCalc = 0;
    static int smartCalc = 0;

    public static void calculateChances() {
        System.out.println("How many horses are running?");
        int nbHorsesRunning = Main.scan.nextInt();
        System.out.println("How many horses are played?");
        int nbHorsesPlayed = Main.scan.nextInt();
        long start = System.nanoTime();
        bruteForceCalculation(nbHorsesRunning, nbHorsesPlayed);
        long end = System.nanoTime();
        System.out.println("Time : " + (end - start));
        start = System.nanoTime();
        smartCalculation(nbHorsesRunning, nbHorsesPlayed);
        end = System.nanoTime();
        System.out.println("Time : " + (end - start));

    }

    private static BigInteger factoriel(BigInteger n) {
        bruteCalc++;
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(factoriel(n.subtract(BigInteger.ONE)));
    }

    private static void bruteForceCalculation(int nbHorsesRunning, int nbHorsesPlayed) {
        BigInteger factn = factoriel(BigInteger.valueOf(nbHorsesRunning));
        BigInteger factNMinP = factoriel(BigInteger.valueOf(nbHorsesRunning - nbHorsesPlayed));
        BigInteger factP = factoriel(BigInteger.valueOf(nbHorsesPlayed));
        BigInteger resultOrder = factn.divide(factNMinP);
        BigInteger resultDisorder = (factn.divide(factNMinP)).divide(factP);

        System.out.println("Chance to win in order : " + resultOrder);
        System.out.println("Chance to win in disorder : " + resultDisorder);
    }

    private static void smartCalculation(int nbHorsesRunning, int nbHorsesPlayed) {
        long resultOrder = nbHorsesRunning;
        long factp = nbHorsesPlayed;
        //n!/(n-p)! = [n*(n-1)*(n-2)*....(n-p+1) *(n-p)! ] / (n-p)!;
        for (int i = 1; i < nbHorsesPlayed; i++) {
            smartCalc++;
            resultOrder *= (nbHorsesRunning - i);
            factp *= i;
        }

        long resultDisorder = resultOrder/factp;
        System.out.println("Smart chance to win in order : " + resultOrder);
        System.out.println("Smart chance to win in disorder : " + resultDisorder);

        System.out.println("bruteCalc : " + bruteCalc + ", smartCalc : " + smartCalc);
    }

}
