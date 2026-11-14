package main;

public class Dice {
    private int numSides;
    private int sideUp;

    public Dice(){
        this.numSides = 6;
        this.sideUp = (int) (Math.random() * numSides) + 1;
    }

    public Dice(int numSides){
        if (numSides < 2) {
            System.out.println("Invalid number of sides.");
            System.out.println("Sides set to 2.");
            this.numSides = 2;
        }
        else {
            this.numSides = numSides;
        }
        this.sideUp = (int) (Math.random() * numSides) + 1;
    }

    public Dice(int numSides, int sideUp){
        if (numSides < 2) {
            System.out.println("Invalid number of sides.");
            System.out.println("Sides set to 2.");
            this.numSides = 2;
        }
        else {
            this.numSides = numSides;
        }
        this.sideUp = sideUp;
    }

    public int getSideUp() {
        return sideUp;
    }

    public void setSideUp(int sideUp) {
        this.sideUp = sideUp;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int newNumSides) {
        if (newNumSides < 2) {
            this.numSides = 2;
        }
        else {
            this.numSides = newNumSides;
        }
    }

    public void roll() {
        sideUp = (int) (Math.random() * numSides) + 1;
    }
}