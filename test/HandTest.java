package test;

import org.junit.Test;
import main.Hand;
import main.Dice;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class HandTest {
    @ Test
    public void testNewListOfDice() {
        Hand h = new Hand(6, 6);
        List<Dice> oldDice = new ArrayList<>();
        for(Dice die : h.getListOfDice()) {
            oldDice.add(die);
        }
        h.newListOfDice(6, 6);
        for(Dice die1 : h.getListOfDice()) {
            for (Dice die2 : oldDice) {
                assertNotSame(die1, die2);
            }
        }
    }

    @ Test
    public void testGetListOfSidesSorted() {
        List<Dice> theDice = new ArrayList<>();
        Dice d1 = new Dice(6, 1);
        Dice d2 = new Dice(6, 2);
        Dice d3 = new Dice(6, 5);
        Dice d4 = new Dice(6, 1);
        theDice.add(d1);
        theDice.add(d2);
        theDice.add(d3);
        theDice.add(d4);
        Hand h = new Hand(theDice);
        System.out.println();
        List<Integer> correct = new ArrayList<>();
        correct.add(1);
        correct.add(1);
        correct.add(2);
        correct.add(5);
        List<Integer> actual = h.getListOfSidesSorted();
        for (int i = 0; i < correct.size(); i++) {
            assertEquals(correct.get(i), actual.get(i));
        }
    }
}
