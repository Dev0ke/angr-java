import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2332Tests {
    private final Solution2332 solution2332 = new Solution2332();

    @Test
    public void example1() {
        int[] buses = {10, 20};
        int[] passengers = {2, 17, 18, 19};
        int capacity = 2;
        int expected = 16;
        Assertions.assertEquals(expected, solution2332.latestTimeCatchTheBus(buses, passengers, capacity));
    }

    @Test
    public void example2() {
        int[] buses = {20, 30, 10};
        int[] passengers = {19, 13, 26, 4, 25, 11, 21};
        int capacity = 2;
        int expected = 20;
        Assertions.assertEquals(expected, solution2332.latestTimeCatchTheBus(buses, passengers, capacity));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] buses = {3};
        int[] passengers = {2, 4};
        int capacity = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2332.latestTimeCatchTheBus(buses, passengers, capacity));
    }

    @Test
    public void example4() {
        int[] buses = {2};
        int[] passengers = {2};
        int capacity = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution2332.latestTimeCatchTheBus(buses, passengers, capacity));
    }

    @Test
    public void example5() {
        int[] buses = {3};
        int[] passengers = {4};
        int capacity = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution2332.latestTimeCatchTheBus(buses, passengers, capacity));
    }

    @Test
    public void example6() {
        int[] buses = {5};
        int[] passengers = {2, 3};
        int capacity = 10000;
        int expected = 5;
        Assertions.assertEquals(expected, solution2332.latestTimeCatchTheBus(buses, passengers, capacity));
    }
}
