import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/5/16.
 */
public class InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> list)
    {
        for(int i = 1; i < list.size(); ++i)
        {
            for(int j = 0; j < i; ++j)
            {
                if(list.get(i) < list.get(j))
                {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}
