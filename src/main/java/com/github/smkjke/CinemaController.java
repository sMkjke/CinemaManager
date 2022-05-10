package com.github.smkjke;

import java.util.ArrayList;
import java.util.Locale;

import static com.github.smkjke.Cinema.*;

public class CinemaController {
    private final CinemaSeatModel model;
    private final CinemaView cinemaView;
    private ArrayList<CinemaSeatModel> seatsList;

    public CinemaController(CinemaSeatModel model, CinemaView cinemaView, ArrayList<CinemaSeatModel> seatsList) {
        this.model = model;
        this.cinemaView = cinemaView;
        this.seatsList = seatsList;
    }

    public void setSeatIsBusy(boolean busy) {
        model.setBusy(busy);
    }

    public boolean getSeatIsBusy() {
        return model.isBusy();
    }

    public int getSeatNumberOfRow() {
        return model.getNumberOfRow();
    }

    public void setSeatNumberOfRow(int numberOfRow) {
        model.setNumberOfRow(numberOfRow);
    }

    public int getSeatNumber() {
        return model.getNumberOfSeat();
    }

    public void setNumberOfSeatToSeat(int numberOfSeat) {
        model.setNumberOfSeat(numberOfSeat);
    }

    public ArrayList<CinemaSeatModel> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(ArrayList<CinemaSeatModel> seatsList) {
        this.seatsList = seatsList;
    }

    public void updateView() {
        cinemaView.print(Cinema.TOTAL_ROWS, SEATS, getSeatsList());
    }

    public boolean changeBusy(int row, int seat) {
        for (CinemaSeatModel i : seatsList) {
            if (i.getNumberOfRow() + 1 == row && i.getNumberOfSeat() + 1 == seat) {
                if (i.isBusy()) {
                    System.out.println("That ticket has already been purchased!");
                    System.out.println();
                    return true;
                }
                i.setBusy(true);
                System.out.println("Ticket price: " + "$" + getSeatsList().get((row * SEATS) - (SEATS - seat) - 1).getPrice());
            }
        }
        return false;
    }

    public void getStatistic() {
        double countBusy = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        double pers;

        for (CinemaSeatModel i : seatsList) {
            if (i.isBusy()) {
                ++countBusy;
                currentIncome += i.getPrice();
            }
            totalIncome += i.getPrice();
        }
        pers = countBusy * 100 / TOTAL_SEATS;

        System.out.println();
        System.out.println("Number of purchased tickets: " + (int) countBusy);
        System.out.println("Percentage: " + String.format(Locale.US, "%.2f", pers) + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

}
