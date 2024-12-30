import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution875Tests {
    private final Solution875 solution875 = new Solution875();

    @Test
    public void example1() {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int expected = 4;
        Assertions.assertEquals(expected, solution875.minEatingSpeed(piles, h));
    }

    @Test
    public void example2() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int expected = 30;
        Assertions.assertEquals(expected, solution875.minEatingSpeed(piles, h));
    }

    @Test
    public void example3() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        int expected = 23;
        Assertions.assertEquals(expected, solution875.minEatingSpeed(piles, h));
    }
}
