package ProjectEuler;

import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/5/16.
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class Problem2 {
    public static ArrayList<Integer> sequence = new ArrayList<>();
    public static void main(String [] args)
    {
        int newVal = 0;
        int sum = 2;
        int cursor1 = 0;
        int cursor2 = 1;
        sequence.add(1);
        sequence.add(2);
        while(newVal <= 4000000)
        {
            newVal = sequence.get(cursor1) + sequence.get(cursor2);
            if(newVal <= 4000000)
            {
                sequence.add(newVal);
                if(newVal % 2 == 0)
                {
                    sum += newVal;
                }
                cursor1++;
                cursor2++;
            }
        }
        System.out.println(sequence);
        System.out.println("Answer: " + sum);
    }
}
