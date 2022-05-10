package com.github.smkjke;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {

    public static int TOTAL_ROWS;
    public static int SEATS;
    public static int TOTAL_SEATS;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        TOTAL_ROWS = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        SEATS = scanner.nextInt();
        TOTAL_SEATS = TOTAL_ROWS * SEATS;
        CinemaSeatModel cinemaSeatModel = new CinemaSeatModel(false, 0, 0);
        CinemaView cinemaView = new CinemaView();

        ArrayList<CinemaSeatModel> cinema = new ArrayList<>(TOTAL_SEATS);

        for (int i = 0; i < TOTAL_ROWS; i++) {
            for (int j = 0; j < SEATS; j++) {
                cinema.add(new CinemaSeatModel(false, i, j));
            }
        }
        CinemaController cinemaController = new CinemaController(cinemaSeatModel, cinemaView, cinema);

        boolean isExit = true;
        while (isExit) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            String input = scanner.next();

            switch (input) {
                case ("1"):
                    cinemaController.updateView();
                    break;
                case ("2"):
                    System.out.println();
                    boolean check = true;
                    while (check) {
                        System.out.println("Enter a row number:");
                        int row = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seat = scanner.nextInt();
                        System.out.println();
                        if (row * SEATS > cinemaController.getSeatsList().size()) {
                            System.out.println("Wrong input!");
                            break;
                        }
                        check = cinemaController.changeBusy(row, seat);
                    }
                    System.out.println();
                    cinemaController.updateView();
                    break;
                case ("3"):
                    cinemaController.getStatistic();
                    break;
                case ("0"):
                    isExit = false;
                    break;
            }
        }
    }
}