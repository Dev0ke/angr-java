import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution904Tests {
    private final Solution904 solution904 = new Solution904();

    @Test
    public void example1() {
        int[] fruits = {1, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution904.totalFruit(fruits));
    }

    @Test
    public void example2() {
        int[] fruits = {0, 1, 2, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution904.totalFruit(fruits));
    }

    @Test
    public void example3() {
        int[] fruits = {1, 2, 3, 2, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution904.totalFruit(fruits));
    }

    @Test
    public void example4() {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution904.totalFruit(fruits));
    }
}