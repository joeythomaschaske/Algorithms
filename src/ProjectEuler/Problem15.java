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
        ArrayList<ArrayList<BigInteger>> grid = new ArrayList<>();
        for(int i = 0; i <= 20; ++i)
        {
            ArrayList<BigInteger> column = new ArrayList<>();
            for(int j = 0; j <= 20; ++j)
            {
                column.add(BigInteger.valueOf(0));
            }
            grid.add(column);
        }
        System.out.println("Answer: " + numberPaths(grid));
        String gridString = "";
        for(int i = 0; i <= 20; ++i)
        {
            for(int j = 0; j <= 20; ++j)
            {
                gridString += grid.get(j).get(i)  + " ";
            }
            gridString += "\n";
        }
        System.out.println("Grid: \n" + gridString);
    }

    private static BigInteger numberPaths(ArrayList<ArrayList<BigInteger>> grid)
    {
        for(int i = 0; i <= 20; ++i)
        {
            for(int j = 0; j <= 20; ++j)
            {
                int x = j;
                int y = i;
                if(x - 1 < 0 || y - 1 < 0)
                {
                    grid.get(x).set(y, BigInteger.ONE);
                }
                else
                {
                    BigInteger topVal = grid.get(x - 1).get(y);
                    BigInteger leftVal = grid.get(x).get(y - 1);
                    grid.get(x).set(y, topVal.add(leftVal));
                }
            }
        }
        return grid.get(20).get(20);
    }
}
