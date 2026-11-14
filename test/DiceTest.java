package test;

import org.junit.Test;

import main.Dice;
import static org.junit.Assert.*;

public class DiceTest {
    @ Test
    public void testGetSideUpSetSideUp() {
        Dice ex = new Dice();
        for (int i = 1; i < 7; i++) {
            int num = i;
            ex.setSideUp(num);
            int side = ex.getSideUp();
            assertEquals(num, side);
        }
    }

    // @ Test
    // public void name() {

    // }
}