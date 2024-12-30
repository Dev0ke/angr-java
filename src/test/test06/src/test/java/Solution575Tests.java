import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution575Tests {
    private final Solution575 solution575 = new Solution575();

    @Test
    public void example1() {
        int[] candyType = {1, 1, 2, 2, 3, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution575.distributeCandies(candyType));
    }

    @Test
    public void example2() {
        int[] candyType = {1, 1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution575.distributeCandies(candyType));
    }

    @Test
    public void example3() {
        int[] candyType = {6, 6, 6, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solution575.distributeCandies(candyType));
    }
}
