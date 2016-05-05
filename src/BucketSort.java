import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/4/16.
 */
public class BucketSort {
    public static ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> list, int radixPosition)
    {
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 10; ++i)
        {
            buckets.add(new ArrayList<Integer>());
        }
        for(Integer i : list)
        {
            int placement = (int) (i / Math.pow(10, radixPosition)) % 10;
            buckets.get(placement).add(i);
        }
        return buckets;
    }
}
