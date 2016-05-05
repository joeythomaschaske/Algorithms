import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by josephthomaschaske on 5/4/16.
 */
public class RadixSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> list)
    {
        int largestNum = 0;
        for(Integer i : list)
        {
            int numLength = String.valueOf(i).length();
            if(numLength > largestNum)
                largestNum = numLength;
        }
        for(int i = 0; i < largestNum; ++i)
        {
            ArrayList<ArrayList<Integer>> buckets = BucketSort.sort(list, i);
            list = new ArrayList<>();
            for(ArrayList<Integer> array : buckets)
            {
                for(Integer j : array)
                {
                    list.add(j);
                }
            }
        }
        return list;
    }
}
