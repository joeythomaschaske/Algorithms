package ProjectEuler;

/**
 * Created by josephthomaschaske on 5/6/16.
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
public class Problem10 {
    public static void main(String [] args){
        long sum = 0;
        for(int i = 2; i < 2000000; ++i)
        {
            if(isPrime(i))
            {
                sum += i;
            }
        }
        System.out.println("Answer: " + sum);
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
