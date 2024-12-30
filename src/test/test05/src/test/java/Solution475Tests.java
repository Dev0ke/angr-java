import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution475Tests {
    private final Solution475 solution475 = new Solution475();

    @Test
    public void example1() {
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        int expected = 1;
        Assertions.assertEquals(expected, solution475.findRadius(houses, heaters));
    }

    @Test
    public void example2() {
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution475.findRadius(houses, heaters));
    }

    @Test
    public void example3() {
        int[] houses = {1, 5};
        int[] heaters = {2};
        int expected = 3;
        Assertions.assertEquals(expected, solution475.findRadius(houses, heaters));
    }
}
