package ProjectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;

/**
 * The following iterative sequence is defined for the set of positive integers:

 n → n/2 (n is even)
 n → 3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:

 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?
 * Created by josephthomaschaske on 5/28/16.
 */
public class Problem14 {
    public static void main(String [] args)
    {
        ArrayList<BigInteger> numbers = new ArrayList<>();
        for(int i = 1; i <= 1000000; ++i)
        {
            numbers.add(BigInteger.valueOf(i));
        }

        int longestChain = 0;
        BigInteger longestNum = BigInteger.valueOf(0);

        for(BigInteger i : numbers)
        {
            BigInteger copyOfI = i;
            int length = 1; //the number itself
            while(i.compareTo(BigInteger.valueOf(1)) != 0)
            {
                if(i.mod(BigInteger.valueOf(2)) == BigInteger.ZERO)
                {
                    i = i.divide(BigInteger.valueOf(2));
                    length += 1;
                }
                else if(i != BigInteger.ONE)
                {
                    i = i.multiply(BigInteger.valueOf(3));
                    i = i.add(BigInteger.valueOf(1));
                    length += 1;
                }
                else
                {
                    length += 1; //adding the number 1
                }
            }
            if(length >= longestChain)
            {
                longestChain = length;
                longestNum = copyOfI;
            }
        }
        System.out.println("Answer: " + longestNum);
    }
}
