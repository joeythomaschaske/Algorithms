import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/5/16.
 */
public class InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> list)
    {
        for(int i = 1; i < list.size(); ++i)
        {
            int valToSort = list.get(i);
            for(int j = 0; j <= i; ++j)
            {
                int valToCompare = list.get(j);
                if(valToSort < valToCompare)
                {
                    list.set(i, valToCompare);
                    list.set(j, valToSort);
                }
            }
        }
        return list;
    }
}
