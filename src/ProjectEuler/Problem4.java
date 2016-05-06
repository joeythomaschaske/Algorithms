package ProjectEuler;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
    public static void main(String [] args)
    {
        int largestProduct = 0;
        for(int i = 999; i >= 100; --i)
        {
            for(int j = 999; j >= 100; --j)
            {
                int product = i * j;
                if(isPalindrome(product) && product > largestProduct)
                {
                    largestProduct = product;
                }
            }
        }
        System.out.println(largestProduct);
    }

    private static boolean isPalindrome(int number)
    {
        String numberAsString = String.valueOf(number);
        int cursor1 = 0;
        int cursor2 = numberAsString.length() - 1;
        while(cursor1 <= cursor2)
        {
            if(numberAsString.charAt(cursor1) != numberAsString.charAt(cursor2))
            {
                return false;
            }
            cursor1++;
            cursor2--;
        }
        return true;
    }
}
