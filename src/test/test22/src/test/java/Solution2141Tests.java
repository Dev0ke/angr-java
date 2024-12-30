import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2141Tests {
    private final Solution2141 solution2141 = new Solution2141();

    @Test
    public void example1() {
        int n = 2;
        int[] batteries = {3, 3, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution2141.maxRunTime(n, batteries));
    }

    @Test
    public void example2() {
        int n = 2;
        int[] batteries = {1, 1, 1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution2141.maxRunTime(n, batteries));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = 3;
        int[] batteries = {10, 10, 3, 5};
        int expected = 8;
        Assertions.assertEquals(expected, solution2141.maxRunTime(n, batteries));
    }

    @Test
    public void example4() {
        int n = 12;
        int[] batteries = {11,89,16,32,70,67,35,35,31,24,41,29,6,53,78,83};
        int expected = 43;
        Assertions.assertEquals(expected, solution2141.maxRunTime(n, batteries));
    }
}