/* 
Homework 3
CPSC224
11/8/2026
Author: Mac Prouty
*/

import java.util.*;

public class Farkle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        System.out.println("Farkle Rolling and Scoring in Java");
        System.out.println("************************************************************************");
        System.out.println("*                     Zag Farkle by Mac Prouty!                        *");
        System.out.println("*                         Copyright: 2026                              *");
        System.out.println("************************************************************************");
        List<Player> players = getPlayerList(input);
        System.out.println();
        System.out.print("How many points would you like to play in this game? ");
        int winNum = input.nextInt();
        boolean endGame = false;
        int endGameStarter = -1;
        input.nextLine();
        if (winNum <= 0) {
            winNum = 10000;
        }
        System.out.println();
        boolean win = false;
        boolean cont;
        while (!win) {
            for (int i = 0; i < players.size(); i++) {
                Player p = players.get(i);
                cont = true;
                int turnPoints = 0;
                p.setHand(new Hand(6, 6));
                while (cont) {
                    System.out.println(p.getName() + ", it is your turn! Rolling dice...");
                    int newPoints = p.getHand().turn();
                    if (newPoints == 0) {
                        System.out.println("You farkled, so your turn is over :(");
                        turnPoints = 0;
                        break;
                    }
                    turnPoints += newPoints;
                    System.out.println("Current turn score: " + turnPoints);
                    String answer;
                    if (p.getHand().getListOfSavedDice().size() == 6) {
                        System.out.println("************************");
                        System.out.println("****** HOT HAND!!! *****");
                        System.out.println("************************");
                        System.out.println("Would you like to roll 6 new dice or bank your points? (R/B)");
                        answer = input.nextLine().toUpperCase();
                        while (!answer.equals("R") && !answer.equals("B")) {
                            System.out.print("Please enter R or B: ");
                            answer = input.nextLine().toUpperCase();
                        }
                        if (answer.equals("R")) {
                            p.setHand(new Hand(6, 6));
                        }
                    } else {
                        System.out.println("Would you like to keep rolling or bank your points? (R/B)");
                        answer = input.nextLine().toUpperCase();
                        while (!answer.equals("R") && !answer.equals("B")) {
                            System.out.print("Please enter R or B: ");
                            answer = input.nextLine().toUpperCase();
                        }
                    }
                    if (answer.equals("B")) {
                    p.addPoints(turnPoints);
                    cont = false;
                    }
                    System.out.println();
                }
                if (!endGame && p.getPoints() >= winNum) {
                    endGame = true;
                    endGameStarter = i;
                }
                System.out.println();
                System.out.println("Current total points:");
                for (Player pl : players) {
                    System.out.println(pl.getName() + " " + pl.getPoints());
                }
                if (endGame && i == players.size() - 1) {
                    Player winner = players.get(0);
                    for (Player pl : players) {
                        if (pl.getPoints() > winner.getPoints()) {
                            winner = pl;
                        }
                    }
                    System.out.println();
                    System.out.println("Game Over!");
                    System.out.println("Winner: " + winner.getName() + " with " + winner.getPoints() + " points!");
                    return;
                }
            }
        }
    }

    public static String getNameViaAsking(Scanner sName) {
        String name = sName.nextLine();
        if (name.isEmpty()) {
            name = "Unknown Player";
        }
        else {
            name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        }
        return name;
    }

    public static List<Player> getPlayerList(Scanner sName) {
        List<Player> playerList = new ArrayList<>();
        List<String> playerNames = new ArrayList<>();
        System.out.print("How many players are playing? ");
        int numPlayers = sName.nextInt();
        if (numPlayers < 1) {
            numPlayers = 1;
        }
        sName.nextLine();
        System.out.println();
        ArrayList<String> defaultNames = new ArrayList<>
        (Arrays.asList("Jennifer", "Tom", "Malcolm", "Oliver", "Madeline",
        "Spencer", "Molly", "Artemis", "Asa", "Bianca", "Theo", "Daniel", 
        "Atticus", "Andrew", "Savannah", "Charlotte", "David", "Lily"));
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("What is player #" + (i + 1) + "'s name? ");
            System.out.println("If you would like to be assigned a default name, hit enter  ");
            String name = getNameViaAsking(sName);
            if (name.equalsIgnoreCase("Unknown Player")) {
                name = defaultNames.get(i % defaultNames.size());
            }
            playerNames.add(name);
            Player p = new Player(new Hand(6, 6), name);
            playerList.add(p);
        }
        return playerList;
    }
}