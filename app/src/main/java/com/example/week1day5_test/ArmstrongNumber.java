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

