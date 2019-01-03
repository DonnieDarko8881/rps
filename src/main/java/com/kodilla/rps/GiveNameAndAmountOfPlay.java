package com.kodilla.rps;

import java.util.Scanner;

public class GiveNameAndAmountOfPlay {

    int amountOfPlay;
    Scanner scanner = new Scanner(System.in);

    public int getAmountOfPlay() {
        return amountOfPlay;
    }

    public int setAmountOfPlay(int amountOfPlay) {
        return this.amountOfPlay = amountOfPlay;
    }

    public void giveName(User user, Scanner scanner) {
        System.out.println("Enter you name and press \"Enter\"");
        user.setName(scanner.nextLine());
        System.out.println("Witaj " + user.getName() + " !");
    }

    public void askAmountOfPlay(User user) {
        System.out.println("How many times do you want to Play");
        amountOfPlay = setAmountOfPlay(scanner.nextInt());
        System.out.println("so, " + user.getName() + " You win if you win " + amountOfPlay + " times!");
    }

}
