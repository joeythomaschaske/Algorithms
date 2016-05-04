import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/1/16.
 */
public class Main {
    public static void main(String [] args) {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0; i < 100; ++i)
        {
            randomNumbers.add((int)(Math.random() * 1000));
        }
        System.out.println(randomNumbers);
        System.out.println(MergeSort.sort(randomNumbers));
    }
}
