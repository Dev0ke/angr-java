import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1423Tests {
    private final Solution1423 solution1423 = new Solution1423();

    @Test
    public void example1() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int expected = 12;
        Assertions.assertEquals(expected, solution1423.maxScore(cardPoints, k));
    }

    @Test
    public void example2() {
        int[] cardPoints = {2, 2, 2};
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution1423.maxScore(cardPoints, k));
    }

    @Test
    public void example3() {
        int[] cardPoints = {9, 7, 7, 9, 7, 7, 9};
        int k = 7;
        int expected = 55;
        Assertions.assertEquals(expected, solution1423.maxScore(cardPoints, k));
    }

    @Test
    public void example4() {
        int[] cardPoints = {1, 1000, 1};
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1423.maxScore(cardPoints, k));
    }

    @Test
    public void example5() {
        int[] cardPoints = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;
        int expected = 202;
        Assertions.assertEquals(expected, solution1423.maxScore(cardPoints, k));
    }
}
