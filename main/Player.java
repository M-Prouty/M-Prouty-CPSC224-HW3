package main;
public class Player {
    private Hand hand;
    private String name;
    private int points;

    public Player(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public int getPoints() {
        return this.points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}