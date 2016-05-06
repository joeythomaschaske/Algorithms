import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/1/16.
 */
public class Main {
    public static void main(String [] args) {
        ArrayList<Integer> randomNumbers = RandomListGenerator.generateList();
        System.out.println(randomNumbers);
        System.out.println(MergeSort.sort(randomNumbers));

        System.out.println('\n');

        randomNumbers = RandomListGenerator.generateList();
        System.out.println(randomNumbers);
        System.out.println(QuickSort.sort(randomNumbers));

        System.out.println('\n');

        randomNumbers = RandomListGenerator.generateList();
        System.out.println(randomNumbers);
        System.out.println(BucketSort.sort(randomNumbers, 0));

        System.out.println('\n');

        randomNumbers = RandomListGenerator.generateList();
        System.out.println(randomNumbers);
        System.out.println(RadixSort.sort(randomNumbers));

        System.out.println('\n');

        randomNumbers = RandomListGenerator.generateList();
        System.out.println(randomNumbers);
        System.out.println(InsertionSort.sort(randomNumbers));
    }
}
