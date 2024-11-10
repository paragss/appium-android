package Utility;

import java.util.*;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {
        int[] intArray = {1,2,2,3,4,4,4,5,5,6,6,6,6,7,7,7,7,7};
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int i : intArray){
            if(freqMap.containsKey(i)){
                freqMap.put(i,freqMap.get(i)+1);
            }
            else
                freqMap.put(i,1);
        }
        System.out.println("Elements and its frequency:  "+ freqMap);
        ArrayList<Integer> tempList = new ArrayList<>();

        for(int temp : freqMap.keySet()){
            tempList.add(freqMap.get(temp));
        }
        System.out.println("frequency collection "+ (tempList));
        Collections.sort(tempList);
        System.out.println("frequency collection "+ (tempList));


        //Java 8 stream
//        Arrays.stream(intArray).collect

    }
}
