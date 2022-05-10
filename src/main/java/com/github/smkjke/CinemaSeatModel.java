package com.github.smkjke;


public class CinemaSeatModel {
    private boolean isBusy;
    private int numberOfRow;
    private int numberOfSeat;
    private int price;

    public CinemaSeatModel( boolean isBusy, int numberOfRow, int numberOfSeat) {
        this.isBusy = isBusy;
        this.numberOfRow = numberOfRow;
        this.numberOfSeat = numberOfSeat;
        this.price = countPrice();
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void print() {
        if (!this.isBusy()) {
            System.out.print("S" + " ");
        } else
            System.out.print("B" + " ");

    }
    private int countPrice(){
        if (Cinema.TOTAL_SEATS <= 60 || getNumberOfRow() < Cinema.TOTAL_ROWS / 2) {
            this.setPrice(10);
            return 10;
        } else {
            this.setPrice(8);
            return 8;
        }
    }
}
