package com.kodilla.rps;

public class User {
    private String name;
    private int amountOfWin = 0;
    private int result;

    public int getResult() {
        return result;
    }

    public int setResult(int result) {
        return this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfWin() {
        return amountOfWin;
    }

    public int setAmountOfWin(int amountOfWin) {
        return this.amountOfWin = amountOfWin;
    }
}
