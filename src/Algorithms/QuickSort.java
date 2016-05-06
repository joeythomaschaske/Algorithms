package Algorithms;

import java.util.ArrayList;

/**
 * Created by josephthomaschaske on 5/3/16.
 */
public class QuickSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> list){
        if(list.size() <= 1){
            return list;
        }
        else {
            int randomPivot = list.get((int) (Math.random() * list.size()));
            ArrayList<Integer> lessThan = new ArrayList<>();
            ArrayList<Integer> equalTo = new ArrayList<>();
            ArrayList<Integer> greaterThan = new ArrayList<>();
            for (Integer i : list) {
                if (i < randomPivot)
                    lessThan.add(i);
                else if (i == randomPivot)
                    equalTo.add(i);
                else
                    greaterThan.add(i);
            }
            lessThan = sort(lessThan);
            greaterThan = sort(greaterThan);
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (Integer i : lessThan) {
                result.add(i);
            }
            for (Integer i : equalTo) {
                result.add(i);
            }
            for (Integer i : greaterThan) {
                result.add(i);
            }
            return result;
        }
    }
}
