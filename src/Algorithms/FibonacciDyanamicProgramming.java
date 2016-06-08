package Algorithms;

/**
 * Created by josephthomaschaske on 6/7/16.
 */
public class FibonacciDyanamicProgramming {
    public static void main(String [] args){
        System.out.println(fibonacci(50)); //supa dupa fast
        System.out.println(fibonacciRecursive(50, 0)); //slow
    }

    private static int fibonacci(int n){
        return fibonacci(n, new int[n + 1]);
    }
    private static int fibonacci(int i, int [] memo){
        if(i == 0 || i == 1){
            return i;
        }
        else {
            if(memo[i] == 0){
                memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
            }
            return memo[i];
        }
    }

    private static int fibonacciRecursive(int n, int fib){
        if(n == 0 || n == 1)
            return n;
        else {
            fib += fibonacciRecursive(n - 1, fib) + fibonacciRecursive(n - 2, fib);
        }
        return fib;
    }
}
