import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/3/16.
 */
public class RandomListGenerator
{
    public static ArrayList<Integer> generateList()
    {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0; i < 100; ++i)
        {
            randomNumbers.add((int)(Math.random() * 1000));
        }
        return randomNumbers;
    }
}
