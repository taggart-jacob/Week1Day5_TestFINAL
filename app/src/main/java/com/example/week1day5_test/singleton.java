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
