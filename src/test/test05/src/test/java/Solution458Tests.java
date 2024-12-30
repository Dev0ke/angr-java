import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution458Tests {
    private final Solution458 solution458 = new Solution458();

    @Test
    public void example1() {
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;
        int expected = 5;
        Assertions.assertEquals(expected, solution458.poorPigs(buckets, minutesToDie, minutesToTest));
    }

    @Test
    public void example2() {
        int buckets = 4;
        int minutesToDie = 15;
        int minutesToTest = 15;
        int expected = 2;
        Assertions.assertEquals(expected, solution458.poorPigs(buckets, minutesToDie, minutesToTest));
    }

    @Test
    public void example3() {
        int buckets = 4;
        int minutesToDie = 15;
        int minutesToTest = 30;
        int expected = 2;
        Assertions.assertEquals(expected, solution458.poorPigs(buckets, minutesToDie, minutesToTest));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/poor-pigs/submissions/520042863/
        int buckets = 125;
        int minutesToDie = 1;
        int minutesToTest = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution458.poorPigs(buckets, minutesToDie, minutesToTest));
    }
}