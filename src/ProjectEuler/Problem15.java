package ProjectEuler;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/28/16.
 */
public class Problem15 {
    public static void main(String [] args)
    {
        int x = 20;
        int y = 20;
        BigInteger numPaths = BigInteger.valueOf(0);
        System.out.println("Answer: " + numPaths(x, y, numPaths));
    }

    private static BigInteger numPaths(int x, int y, BigInteger pathsFound)
    {
        if(x == 0 && y == 0)
        {
            pathsFound = pathsFound.add(BigInteger.valueOf(1));
        }
        else
        {
            if(x > 0)
            {
                pathsFound = numPaths(x - 1, y, pathsFound);
            }
            if(y > 0)
            {
                pathsFound = numPaths(x, y - 1, pathsFound);
            }
        }
        return pathsFound;
    }
}
