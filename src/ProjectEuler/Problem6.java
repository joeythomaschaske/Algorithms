package ProjectEuler;

/**
 * Created by josephthomaschaske on 5/5/16.
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 {
    public static void main(String [] args)
    {
        int sumOfSquares = 0;
        int sum = 0;
        for(int i = 1; i <= 100; ++i)
        {
            sumOfSquares += Math.pow(i, 2);
            sum += i;
        }
        System.out.println("Answer: " + (Math.pow(sum, 2) - sumOfSquares));
    }
}
