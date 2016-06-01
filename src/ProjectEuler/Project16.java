package ProjectEuler;

import java.math.BigInteger;

/**
 * Created by josephthomaschaske on 5/29/16.
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

 What is the sum of the digits of the number 2^1000?
 */
public class Project16 {
    public static void main(String [] args)
    {
        BigInteger powerOf2 = BigInteger.valueOf(2);
        for(int i = 0; i < 999; ++i)
        {
            powerOf2 = powerOf2.multiply(BigInteger.valueOf(2));
        }
        System.out.println(powerOf2);
        BigInteger sum = BigInteger.valueOf(0);
        int length = String.valueOf(powerOf2).length();
        String powerOf2AsString = powerOf2.toString();
        for(int i = 0; i < length; ++i)
        {
            sum = sum.add(BigInteger.valueOf(Integer.parseInt(String.valueOf(powerOf2AsString.charAt(i)))));
        }
        System.out.println("Answer: " + sum);
    }
}
