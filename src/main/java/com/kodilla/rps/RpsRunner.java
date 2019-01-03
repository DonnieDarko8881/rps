package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;


public class RpsRunner {
    public static void main(String[] args) {
        User user = new User();
        User computer = new User();
        boolean end = false;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Rps rps = new Rps();

        GiveNameAndAmountOfPlay giveNameAndAmountOfPlay = new GiveNameAndAmountOfPlay();
        giveNameAndAmountOfPlay.giveName(user, scanner);
        giveNameAndAmountOfPlay.askAmountOfPlay(user);

        rps.showRules();
        while (!end) {

            String textUser = scanner.nextLine();

            if (textUser.charAt(0) == 'x') {
                boolean endSure = false;
                while (!endSure) {
                    System.out.println("Are You sure you want to exit game ? yes/no");
                    String areYouSure = scanner.nextLine();
                    if (areYouSure.equals("yes")) {
                        end = true;
                        endSure = true;
                    } else if (areYouSure.equals("no")) {
                        rps.showRules();
                        endSure = true;
                    } else {
                        System.out.println("You can write in only yes or no");
                    }
                }
            }


            user.setResult(textUser.charAt(0) - 48);
            computer.setResult(random.nextInt(3) + 1);
            rps.whoWinRound(user, computer);
            rps.infoAboutRound(user, computer);

            if (textUser.charAt(0) == 'n') {
                boolean endSure = false;
                while (!endSure) {
                    System.out.println("Are You sure you want to play again ? yes/no");
                    String areYouSure = scanner.nextLine();
                    if (areYouSure.equals("yes")) {
                        user.setAmountOfWin(0);
                        computer.setAmountOfWin(0);
                        giveNameAndAmountOfPlay.giveName(user, scanner);
                        giveNameAndAmountOfPlay.askAmountOfPlay(user);
                        rps.showRules();
                        endSure = true;
                    } else if (areYouSure.equals("no")) {
                        rps.showRules();
                        endSure = true;
                    } else {
                        System.out.println("You can write in only yes or no");

                    }
                }
            }

            if (giveNameAndAmountOfPlay.getAmountOfPlay() == user.getAmountOfWin()) {
                System.out.println("You are Winner");
                end = rps.playAgainEnd(user, computer, end, scanner, rps, giveNameAndAmountOfPlay);
            } else if (giveNameAndAmountOfPlay.getAmountOfPlay() == computer.getAmountOfWin()) {
                System.out.println("You are Loser");
                end = rps.playAgainEnd(user, computer, end, scanner, rps, giveNameAndAmountOfPlay);

            }
        }
    }
}
