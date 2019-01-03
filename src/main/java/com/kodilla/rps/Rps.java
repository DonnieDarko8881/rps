package com.kodilla.rps;
import java.util.Scanner;

public class Rps {

    public void showRules() {
        System.out.println("Press 1-3 to play \n" +
                "1 - Rock\n" +
                "2 - paper\n" +
                "3 - scissor\n" +
                "x - end game\n" +
                "n -  play again\n");
    }

    private int addPoint(User user) {

        int temp = user.getAmountOfWin();
        return user.setAmountOfWin(++temp);
    }

    public void whoWinRound(User player, User computer) {
        if (player.getResult() == 1 && computer.getResult() == 1) {
            remis();
        } else if (player.getResult() == 1 && computer.getResult() == 2) {
            addPoint(computer);
        } else if (player.getResult() == 1 && computer.getResult() == 3) {
            addPoint(player);
        } else if (player.getResult() == 2 && computer.getResult() == 1) {
            addPoint(player);
        } else if (player.getResult() == 2 && computer.getResult() == 2) {
            remis();
        } else if (player.getResult() == 2 && computer.getResult() == 3) {
            addPoint(computer);
        } else if (player.getResult() == 3 && computer.getResult() == 1) {
            addPoint(computer);
        } else if (player.getResult() == 3 && computer.getResult() == 2) {
            addPoint(player);
        } else if (player.getResult() == 3 && computer.getResult() == 3) {
            remis();
        }
    }

    private void remis() {
        System.out.println("remis");
    }

    public void infoAboutRound(User player, User computer) {
        if (player.getResult() == 1 && computer.getResult() == 2) {
            System.out.println("Computer's PAPER covered your ROCK, Computer has won this Round");
        } else if (player.getResult() == 1 && computer.getResult() == 3) {
            System.out.println("Computer's SCISSORS broke on your ROCK, You have won this Round");
        } else if (player.getResult() == 2 && computer.getResult() == 1) {
            System.out.println("Your PAPER covered Computer's ROCK, You have won this Round");
        } else if (player.getResult() == 2 && computer.getResult() == 3) {
            System.out.println("Computer's SCISSORS cut your PAPER, Computer has won this Round");
        } else if (player.getResult() == 3 && computer.getResult() == 1) {
            System.out.println("Your SCISSORS broke on Computer's ROCK, Computer has won this Round");
        } else if (player.getResult() == 3 && computer.getResult() == 2) {
            System.out.println("Your SCISSORS cut Computer's PAPER, You has won this Round");
        }
    }

    public static boolean playAgainEnd(User user, User computer, boolean end, Scanner scanner, Rps rps, GiveNameAndAmountOfPlay giveNameAndAmountOfPlay) {
        System.out.println("Do you want to play again ? yes/no");

        String playAgainEndGame = scanner.nextLine();

        if (playAgainEndGame.equals("yes")) {
            user.setAmountOfWin(0);
            computer.setAmountOfWin(0);
            giveNameAndAmountOfPlay.giveName(user, scanner);
            giveNameAndAmountOfPlay.askAmountOfPlay(user);
            rps.showRules();

        } else if (playAgainEndGame.equals("no")) {
            end = true;

        } else {
            System.out.println("You can write in only yes or no");
            end = playAgainEnd(user, computer, end, scanner, rps, giveNameAndAmountOfPlay);
        }

        return end;
    }

}
