package test;

import org.junit.Test;
import main.Hand;
import main.Dice;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    @ Test
    public void testCalcPointsSixOfAKind() {
        Hand h = new Hand(6, 6);
        // six 1s
        List<List<Integer>> options = Arrays.asList(Arrays.asList(1, 1, 1, 1, 1, 1));
        int points = h.calcPoints(options);
        assertEquals(1300, points);
        // six 2s
        options = Arrays.asList(Arrays.asList(2, 2, 2, 2, 2, 2));
        points = h.calcPoints(options);
        assertEquals(800, points);
        // six 3s
        options = Arrays.asList(Arrays.asList(3, 3, 3, 3, 3, 3));
        points = h.calcPoints(options);
        assertEquals(1200, points);
        // six 4s
        options = Arrays.asList(Arrays.asList(4, 4, 4, 4, 4, 4));
        points = h.calcPoints(options);
        assertEquals(1600, points);
        // six 5s
        options = Arrays.asList(Arrays.asList(5, 5, 5, 5, 5, 5));
        points = h.calcPoints(options);
        assertEquals(2000, points);
        // six 6s
        options = Arrays.asList(Arrays.asList(6, 6, 6, 6, 6, 6));
        points = h.calcPoints(options);
        assertEquals(2400, points);
    }

    public void testCalcPointsFourOfAKind() {
        Hand h = new Hand(6, 6);
        // four 1s
        List<List<Integer>> options = Arrays.asList(Arrays.asList(1, 1, 1, 1));
        int points = h.calcPoints(options);
        assertEquals(1100, points);
        // four 2s
        options = Arrays.asList(Arrays.asList(2, 2, 2, 2));
        points = h.calcPoints(options);
        assertEquals(400, points);
        // four 3s
        options = Arrays.asList(Arrays.asList(3, 3, 3, 3));
        points = h.calcPoints(options);
        assertEquals(600, points);
        // four 4s
        options = Arrays.asList(Arrays.asList(4, 4, 4, 4));
        points = h.calcPoints(options);
        assertEquals(800, points);
        // four 5s
        options = Arrays.asList(Arrays.asList(5, 5, 5, 5));
        points = h.calcPoints(options);
        assertEquals(1000, points);
        // four 6s
        options = Arrays.asList(Arrays.asList(6, 6, 6, 6));
        points = h.calcPoints(options);
        assertEquals(1200, points);
    }
    
    public void testCalcPointsTriples() {
        Hand h = new Hand(6, 6);
        // one set of three 1s
        List<List<Integer>> options = Arrays.asList(Arrays.asList(1, 1, 1));
        int points = h.calcPoints(options);
        assertEquals(1000, points);
        // one set of three 2s
        options = Arrays.asList(Arrays.asList(2, 2, 2));
        points = h.calcPoints(options);
        assertEquals(200, points);
        // one set of three 3s
        options = Arrays.asList(Arrays.asList(2, 2, 2));
        points = h.calcPoints(options);
        assertEquals(200, points);
        // one set of three 4s
        options = Arrays.asList(Arrays.asList(4, 4, 4));
        points = h.calcPoints(options);
        assertEquals(400, points);
        // one set of three 5s
        options = Arrays.asList(Arrays.asList(5, 5, 5));
        points = h.calcPoints(options);
        assertEquals(500, points);
        // one set of three 6s
        options = Arrays.asList(Arrays.asList(6, 6, 6));
        points = h.calcPoints(options);
        assertEquals(600, points);
    }

    public void dummyTest() {
        assertTrue(true);
    }
}