package com.example.week1day5_test;
//imports java utilities needed for Array and HashMap
import java.util.*;

public class ArrayOccurrences {
    //main method
    public static void main(String[] args) {
        //initializes array and assigns values
        int[] numbers = {1, 2, 2, 2, 3, 5, 1, 7, 9, 7};
        /*sorts the array (this really isn't a necessary step, but I ended up leaving it when I decided to use a hashmap
        instead of a nested for loop with counters...it would have been useful in that process, but this is more
        efficient*/
        Arrays.sort(numbers);
        //runs the functional method
        occurrences(numbers);
    }

    public static void occurrences(int[] num) {
        //creates hashmap with the num array's elements as keys and each element's number of occurrences as values
        HashMap<Integer, Integer> countingMap = new HashMap<Integer, Integer>();
        //checking every element of the num array passed in the argument
        for (int i : num) {
            //if number is present in countMap
            if (countingMap.containsKey(i)) {
                //adds to its associated occurrences count by 1
                countingMap.put(i, countingMap.get(i) + 1);
                //otherwise if the number isn't in the countMap
            } else {
                //add this number to countMap with 1 as its number of occurrences (if the number is only found once in the array loop)
                countingMap.put(i, 1);
            }
        }
        /*prints out the hashMap and gives an explanation of how to interpret the hashMap with a new line between
        the explanation and the printed countMap*/
        System.out.println("Amount of occurrences for each array member (first number is the array member, second number "+
                "is the amount of occurrences for said array member):\n"  + countingMap);
    }
}
