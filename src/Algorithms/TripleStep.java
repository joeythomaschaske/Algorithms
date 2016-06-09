package Algorithms;

/**
 * Created by josephthomaschaske on 6/8/16.
 */
public class TripleStep {
    public static void main(String [] args) {
        int steps = 37;
        int [] memo = new int [steps + 1];
        for(int i = 0; i <= steps; ++i){
            memo[i] = -1;
        }
        System.out.println("Number of Steps: " + computePossibleWays(steps, memo));
    }

    private static int computePossibleWays(int steps, int [] memo) {
        if(steps < 0)
            return 0;
        else if(steps == 0)
            return 1;
        else if(memo[steps] > -1)
            return memo[steps];
        else {
            memo[steps] = computePossibleWays(steps - 1, memo) + computePossibleWays(steps - 2, memo) + computePossibleWays(steps - 3, memo);
            return memo[steps];
        }

    }
}
