package ProjectEuler;

import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/7/16.
 */
public class Problem12 {
    public static void main(String [] args)
    {
        ArrayList<Long> triangles = new ArrayList<>();
        for(long i = 1; true; ++i)
        {
            long sum = 0;
            long j = 1;
            while(j <= i ){
                sum += j;
                ++j;
            }
            triangles.add(sum);
            long numDivisors = 0;
            for(long k = 1; k < sum; ++k)
            {
                if(sum % k == 0) {
                    ++numDivisors;
                    if(numDivisors == 500)
                    {
                        System.out.println("Answer: " + triangles.size());
                        System.exit(0);
                    }
                }

            }
        }
    }
}
