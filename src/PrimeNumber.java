import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
    public static void getPrimes() {
        System.out.println("What is the limit for looking for prime numbers");
        int maxLimit = Main.scan.nextInt();
        long start = System.nanoTime();
        List<Integer> primes = new ArrayList<>();
        brutalForce(maxLimit, primes);
        long end = System.nanoTime();
        //System.out.println(Arrays.toString(new List[]{primes}));
        int time =(int)( (end - start)/Math.pow(10,6));
        System.out.println("Nb Primes found brutally : " + primes.size() + ", in " + time );
        System.out.println("--------------------------");
        primes.clear();
        start = System.nanoTime();
        smartForce(maxLimit, primes);
        end = System.nanoTime();
        time =(int)( (end - start)/Math.pow(10,6));
        System.out.println("Nb Primes found smartly : " + primes.size()+ ", in " +  time);
    }

    private static void brutalForce(int maxLimit, List<Integer> primes) {
        for (int i = 2; i < maxLimit; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes.add(i);
                //System.out.println(i + " is prime");
            }
        }
    }

    private static void smartForce(int maxLimit, List<Integer> primes) {
        for (int i = 2; i < maxLimit; i++) {
            if (isPrime(i)) {
                primes.add(i);
                //System.out.println(i + " is prime");
            }
        }
    }

    private static boolean isPrime(int i) {
        if (i == 2)
            return true;
        if (i % 2 == 0)
            return false;
        for (int j = 3; j*j < i + 2; j += 2) {
            if (i % j == 0)
                return false;
        }
        return true;
    }

}
