import java.util.*;

public class FarkleOld {
    public static void main(String[] args) {
        boolean cont = true;
        Scanner input = new Scanner(System.in);
        int points = 0;
        String name = "Jack";
        Hand myHand = new Hand(6, 6);
        while (cont) {
            System.out.println(name + ", it is your turn! Rolling dice...");
            int new_points = myHand.turn();
            String answer;
            if(new_points == 0) {
                System.out.println("You farkled, so your turn is over :(");
                points = 0;
                break;
            }
            else {
                points += new_points;
            }
            if(myHand.getListOfSavedDice().size() == 6) {
                System.out.println("************************");
                System.out.println("****** HOT HAND!!! *****");
                System.out.println("************************");
                System.out.println("Would you like to roll 6 new dice or bank your points? (R/B)");
                answer = input.nextLine().toUpperCase();
                if(answer.equals("R")) {
                    myHand = new Hand(6, 6);  
                }
            }
            else {
                System.out.println("Would you like to keep rolling or bank your points (R/B)");
                answer = input.nextLine().toUpperCase();
            }
            System.out.println(name + "'s points: " + points);
            if (answer.equals("B") || answer.equals("")) {
                cont = false;
            }
            System.out.println();
        }
        System.out.println("Thank you for playing, " + name + "! You earned " + points + " points.");
    }
}