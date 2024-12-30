import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2105Tests {
    private final Solution2105 solution2105 = new Solution2105();

    @Test
    public void example1() {
        int[] plants = {2, 2, 3, 3};
        int capacityA = 5;
        int capacityB = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution2105.minimumRefill(plants, capacityA, capacityB));
    }

    @Test
    public void example2() {
        int[] plants = {2, 2, 3, 3};
        int capacityA = 3;
        int capacityB = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution2105.minimumRefill(plants, capacityA, capacityB));
    }

    @Test
    public void example3() {
        int[] plants = {5};
        int capacityA = 10;
        int capacityB = 8;
        int expected = 0;
        Assertions.assertEquals(expected, solution2105.minimumRefill(plants, capacityA, capacityB));
    }

    @Test
    public void example4() {
        int[] plants = {1, 2, 4, 4, 5};
        int capacityA = 6;
        int capacityB = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution2105.minimumRefill(plants, capacityA, capacityB));
    }

    @Test
    public void example5() {
        int[] plants = {2, 2, 5, 2, 2};
        int capacityA = 5;
        int capacityB = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution2105.minimumRefill(plants, capacityA, capacityB));
    }
}
