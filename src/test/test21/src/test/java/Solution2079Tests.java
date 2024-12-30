import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2079Tests {
    private final Solution2079 solution2079 = new Solution2079();

    @Test
    public void example1() {
        int[] plants = {2, 2, 3, 3};
        int capacity = 5;
        int expected = 14;
        Assertions.assertEquals(expected, solution2079.wateringPlants(plants, capacity));
    }

    @Test
    public void example2() {
        int[] plants = {1, 1, 1, 4, 2, 3};
        int capacity = 4;
        int expected = 30;
        Assertions.assertEquals(expected, solution2079.wateringPlants(plants, capacity));
    }

    @Test
    public void example3() {
        int[] plants = {7, 7, 7, 7, 7, 7, 7};
        int capacity = 8;
        int expected = 49;
        Assertions.assertEquals(expected, solution2079.wateringPlants(plants, capacity));
    }
}
