package com.github.smkjke;

import java.util.List;

public class CinemaView {

    void print(int rows, int seats, List<CinemaSeatModel> cinema) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int k = 1; k <= seats; k++) {
            System.out.print(k + " ");
        }
        System.out.print("\n");
        int count = 0;
        for (int i = 0; i < rows; i++) {

            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                cinema.get(count).print();
                count++;
            }
            System.out.print("\n");
        }
    }
}
