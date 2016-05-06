package ProjectEuler;

import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/5/16.
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
public class Problem7 {
    public static void main(String [] args)
    {
        ArrayList<Long> primes = new ArrayList<>();
        for(long i = 1l; primes.size() <= 100001; ++i)
        {
            if(isPrime(i))
            {
                primes.add(i);
            }
        }
        //I guess they don't count 1 as prime
        System.out.println("Answer: " + primes.get(10001));
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
