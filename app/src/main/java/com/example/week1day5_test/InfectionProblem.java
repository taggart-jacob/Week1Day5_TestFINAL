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
