import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1575Tests {
    private final Solution1575 solution1575 = new Solution1575();

    @Test
    public void example1() {
        int[] locations = {2, 3, 6, 8, 4};
        int start = 1;
        int finish = 3;
        int fuel = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution1575.countRoutes(locations, start, finish, fuel));
    }

    @Test
    public void example2() {
        int[] locations = {4, 3, 1};
        int start = 1;
        int finish = 0;
        int fuel = 6;
        int expected = 5;
        Assertions.assertEquals(expected, solution1575.countRoutes(locations, start, finish, fuel));
    }

    @Test
    public void example3() {
        int[] locations = {5, 2, 1};
        int start = 0;
        int finish = 2;
        int fuel = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution1575.countRoutes(locations, start, finish, fuel));
    }
}
