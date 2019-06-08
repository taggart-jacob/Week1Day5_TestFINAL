# Week1Day5_TestFINAL

Problem 1: Create a singleton class and make it thread safe.

Solution: 

package com.example.week1day5_test;

    public class singleton
    {
        // private instance, so that it can be
        // accessed by only by getInstance() method

        private static singleton instance;
        // constructor class
        private singleton()
        {
            //constructor
        }

        //synchronization
        synchronized public static singleton getInstance()
        {
            //if instance happens to be null
            if (instance == null)
            {
                //initializes Singleton
                instance = new singleton();
            }
            //returns the Singleton
            return instance;
        }
    }
    
    
Problem 2: Create a function to find the amount of occurrences for each integer value given an integer array.

Solution:

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

Problem 3: Simple Java Program to check or find if a number is Armstrong number or not. An Armstrong number of three digit is a number whose sum of cubes of its digit is equal to its number. For example 153 is an Armstrong number of 3 digit because 1^3+5^3+3^3 or 1+125+27=153

Solution:

package com.example.week1day5_test;

public class ArmstrongNumber{

    public static void main(String args[]) {
        //initializes/assigns a few numbers to test with to see if they are Armstrong numbers
        int num = 179;
        int arm = 153;
        int i = 4698;

        //if the first number is an Armstrong
        if (isArmstrong(num)) {
            //prints out that it is one
            System.out.println(num + " is an Armstrong number");
            //otherwise
        } else {
            //prints that it's not
            System.out.println(num + " is not an Armstrong number");
        }
        //same for the second number
        if (isArmstrong(arm)) {
            System.out.println(arm + " is an Armstrong number");
        } else {
            System.out.println(arm + " is not an Armstrong number");
        }
        //same for third number
        if (isArmstrong(i)) {
            System.out.println(i + " is an Armstrong number");
        } else {
            System.out.println(i + " is not an Armstrong number");
        }

    }

    //method for returning true or false depending on its Armstrong status
    private static boolean isArmstrong(int number) {
        /*initializing and setting an integer for the result of each digit being cubed and all added together and the original
        number passed in the arg*/
        int end = 0;
        int start = number;
        //while loop that continues while the passed number isn't zero
        while (number != 0) {
            //sets a remainder integer to equal the original passed number mod 10
            int remainder = number % 10;
            //the end result is equal to the three remainders cubed plus the end number
            end = end + (remainder*remainder*remainder);
            //eventually will cause the number to equal zero in order to exit the while loop
            number = number / 10;
        }
        //if the originally passed number is equal to the end result
        if (start == end) {
            //returns true
            return true;
        }
        //returns false
        return false;
    }
}

Problem 4: Complete the infected room challenge.

Solution:

package com.example.week1day5_test;

public class InfectionProblem {
    public final boolean isInfected;
    public boolean visited = false;

    InfectionProblem(boolean infected) {
        isInfected = infected;
    }
}

class Outbreak {

    public static boolean isOutbreak(InfectionProblem[][] floor) {
        int result = 0;
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                int tmp = checkRoom(0, floor, i, j);
                if (tmp >= result) result = tmp;
            }
        }
        System.out.println(result + " so");
        return result >= 5;
    }

    public static int checkRoom(int n, InfectionProblem[][] floor, int y, int x) {
        int end = n;

        if (y < 0 || y >= floor.length) return 0;
        if (x < 0 || x >= floor[0].length) return 0;

        if ((floor[y][x]).visited == true) return 0;
        if ((floor[y][x]).isInfected == false) return 0;

        floor[y][x].visited = true;

        end += 1;

        return end + checkRoom(0, floor, y + 1, x)+checkRoom(0, floor, y - 1, x)
        +checkRoom(0, floor, y, x + 1)+checkRoom(0, floor, y, x - 1);
    }

    public static void main(String[] args) {
        InfectionProblem[][] verticalTrue = new InfectionProblem[][]{

                {new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(true), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(true), new InfectionProblem(true), new InfectionProblem(true), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(true), new InfectionProblem(true), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(true), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(true), new InfectionProblem(true), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(true), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(true), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(true), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)},
                {new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false), new InfectionProblem(false)}
        };

        System.out.println(Outbreak.isOutbreak(verticalTrue));
    }
}
