package math;

/**
 * This class includes a number of methods related to prime numbers.
 */
public class Primes {
    /**
     * Prints all primes from 0 to n (inclusive) to {@link System#out System.out} on separate lines.
     * <p>
     * Note that this method is very slow and when fed ints higher than a few hundred thousand, it will start to take a
     * while. Specifically, a preliminary test showed that for n = 10,000,000 the program took approximately one hour to
     * finish.
     * </p>
     * @param n the upper bound that you wish to print to.
     */
    public static void printPrimes(int n) {
        for (int i = 0; i <= n; i++) {
            if (chkPrime(n)) {
                System.out.println(i);
            }
        }
    }

    /**
     * Returns a truth value representing whether or not a given positive integer is prime.
     * @param n the integer being evaluated.
     * @return true if n is prime, false otherwise.
     * @throws IllegalArgumentException If n is negative.
     */
    public static boolean isPrime(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("The argument n must be a positive integer");
        }
        return chkPrime(n);
    }

    /**
     * A private method used internally which lacks the fail-safe mechanism of the public method {@link #isPrime(int)},
     * thus making it slightly faster.
     * @param n the int to evaluate
     * @return a boolean representing whether or not n is prime
     */
    private static boolean chkPrime(int n) {
        //Check if either x is 1 or if x is a even number other than 2
        if (n == 1 || n % 2 == 0 && n != 2) {
            return false;
        }
        //Starting from 3 we check every odd number up to x since the even numbers other than 2 are all not prime.
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
