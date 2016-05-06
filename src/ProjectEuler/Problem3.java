package ProjectEuler;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
*  What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {
    public static void main(String [] args)
    {
        for(long i = (long )Math.sqrt(600851475143L); i > 1; --i)
        {
            if(600851475143L % i == 0 && isPrime(i))
            {
                System.out.println("Answer: " + i);
                System.exit(0);
            }
        }
    }

    private static boolean isPrime(long number)
    {
        for(long i = 2; i <= Math.sqrt(number); ++i)
        {
            if(number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
