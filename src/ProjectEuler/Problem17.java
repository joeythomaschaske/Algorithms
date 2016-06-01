package ProjectEuler;

import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/29/16.
 */
public class Problem17 {
    public static void main(String [] args)
    {
        ArrayList<Integer> numbersAsIntegers = new ArrayList<>();
        for(int i = 1; i <= 1000; ++i)
        {
            numbersAsIntegers.add(i);
        }

        ArrayList<String> numbersAsStrings = new ArrayList<>();
        for(Integer i : numbersAsIntegers)
        {
            numbersAsStrings.add(convertNumberToWord(i));
        }
        System.out.println(numbersAsStrings);
    }

    private static String convertNumberToWord(int numToBeConverted)
    {
        String num = flipWord(String.valueOf(numToBeConverted));
        int numberLength = String.valueOf(num).length();
        String number = "";
        for(int i = 0; i < numberLength; ++i)
        {
            if(i == 3)
            {
                number += " " + convertDigitToWord(String.valueOf(String.valueOf(num).charAt(i)));
                number += " thousand";
            }
            if(i == 2)
            {
                number += " " + convertDigitToWord(String.valueOf(String.valueOf(num).charAt(i)));
                number += " hundred";
            }
            if(numberLength > 2 && i == 2)
            {
                number += " and";
            }
            if(i == 1)
            {
                if(String.valueOf(num).charAt(i) != '1')
                {
                    number += " " + convertTensToWord(String.valueOf(String.valueOf(num).charAt(i)));
                }
                else if(String.valueOf(num).charAt(0) == '1' && String.valueOf(num).charAt(0) != '0' && String.valueOf(num).charAt(0) != '1' && String.valueOf(num).charAt(0) != '2')
                {
                    number += " " + convertTensToWord(String.valueOf(String.valueOf(num).charAt(i)));
                }
                else if(String.valueOf(num).charAt(i) == '1' && String.valueOf(num).charAt(0) == '0')
                {
                    number += " ten";
                    break;
                }
                else if(String.valueOf(num).charAt(i) == '1' && String.valueOf(num).charAt(0) == '1')
                {
                    number += " eleven";
                    break;
                }
                else if(String.valueOf(num).charAt(i) == '1' && String.valueOf(num).charAt(0) == '2')
                {
                    number += " twelve";
                    break;
                }
            }
            if(i == 0)
            {
                number += " " + convertDigitToWord(String.valueOf(String.valueOf(num).charAt(i)));
            }
        }
        return number;
    }

    private static String convertDigitToWord(String digit)
    {
        String word = "";
        switch(digit)
        {
            case "1": word = "one";
                break;
            case "2": word = "two";
                break;
            case "3": word = "three";
                break;
            case "4": word = "four";
                break;
            case "5": word = "five";
                break;
            case "6": word = "six";
                break;
            case "7": word = "seven";
                break;
            case "8": word = "eight";
                break;
            case "9": word = "nine";
                break;
        }
        return word;
    }

    private static String convertTensToWord(String digit)
    {
        String word = "";
        switch(digit)
        {
            case "1": word = "teen";
                break;
            case "2": word = "twenty";
                break;
            case "3": word = "thirty";
                break;
            case "4": word = "forty";
                break;
            case "5": word = "fifty";
                break;
            case "6": word = "sixty";
                break;
            case "7": word = "seventy";
                break;
            case "8": word = "eighty";
                break;
            case "9": word = "ninety";
                break;
        }
        return word;
    }

    private static String flipWord(String number)
    {
        String newWord = "";
        for(int i = number.length() - 1; i >= 0; --i)
        {
            newWord += String.valueOf(number.charAt(i));
        }
        return newWord;
    }
}
