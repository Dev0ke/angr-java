import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1478Tests {
    private final Solution1478 solution1478 = new Solution1478();

    @Test
    public void example1() {
        int[] houses = {1, 4, 8, 10, 20};
        int k = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution1478.minDistance(houses, k));
    }

    @Test
    public void example2() {
        int[] houses = {2, 3, 5, 12, 18};
        int k = 2;
        int expected = 9;
        Assertions.assertEquals(expected, solution1478.minDistance(houses, k));
    }

    @Test
    public void example3() {
        int[] houses = {7, 4, 6, 1};
        int k = 1;
        int expected = 8;
        Assertions.assertEquals(expected, solution1478.minDistance(houses, k));
    }

    @Test
    public void example4() {
        int[] houses = {3, 6, 14, 10};
        int k = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solution1478.minDistance(houses, k));
    }
}
