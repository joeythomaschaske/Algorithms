import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/1/16.
 */
public class MergeSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> list){
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        if(list.size() == 1)
            return list;
        else if(list.size() > 1)
        {
            int midpoint = list.size() / 2;
            for(int i = 0; i < midpoint; ++i)
            {
                l1.add(list.get(i));
            }
            for(int i = midpoint; i < list.size(); ++i)
            {
                l2.add(list.get(i));
            }
            l1 = sort(l1);
            l2 = sort(l2);
        }
        while(!l1.isEmpty() || !l2.isEmpty())
        {
            if(l1.isEmpty()){
                result.add(l2.remove(0));
            }
            else if(l2.isEmpty()){
                result.add(l1.remove(0));
            }
            else if(l1.get(0) < l2.get(0)){
                result.add(l1.remove(0));
            }
            else if(l2.get(0) <= l1.get(0)){
                result.add(l2.remove(0));
            }
        }
        return result;
    }
}
