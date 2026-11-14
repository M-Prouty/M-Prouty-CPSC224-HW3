package test;

import org.junit.Test;
import main.Dice;
import static org.junit.Assert.*;

public class DiceTest {
    @ Test
    public void testGetSideUpSetSideUp() {
        Dice ex = new Dice();
        for (int i = 1; i < 7; i++) {
            ex.setSideUp(i);
            int side = ex.getSideUp();
            assertEquals(i, side);
        }
    }

    @ Test
    public void testGetNumSidesSetNumSides() {
        Dice ex = new Dice();
        for (int i = -5; i < 2; i++) {
            ex.setNumSides(i);
            int numSides = ex.getNumSides();
            assertEquals(2, numSides);
        }
        for (int i = 2; i < 10; i++) {
            ex.setNumSides(i);
            int numSides = ex.getNumSides();
            assertEquals(i, numSides);
        }
    }
}