package ProjectEuler;

/**
 * Created by josephthomaschaske on 5/6/16.
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.

 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {
    public static void main(String [] args){
        for(int i = 0; true; ++i)
        {
            for(int j = 0; j < i; ++j)
            {
                for(int k = 0; k < j; ++k)
                {
                    int aSquared = k * k;
                    int bSquared = j * j;
                    int cSquared = i * i;
                    if((aSquared + bSquared) == cSquared)
                    {
                        //System.out.println("Pythagorean triple" + aSquared + " " + bSquared + " " + cSquared);
                        if((k + j + i) == 1000)
                        {
                            System.out.println("Answer: " + (k * j * i));
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
}