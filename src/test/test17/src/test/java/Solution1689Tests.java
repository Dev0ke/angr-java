import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1689Tests {
    private final Solution1689 solution1689 = new Solution1689();

    @Test
    public void example1() {
        String n = "32";
        int expected = 3;
        Assertions.assertEquals(expected, solution1689.minPartitions(n));
    }

    @Test
    public void example2() {
        String n = "82734";
        int expected = 8;
        Assertions.assertEquals(expected, solution1689.minPartitions(n));
    }

    @Test
    public void example3() {
        String n = "27346209830709182346";
        int expected = 9;
        Assertions.assertEquals(expected, solution1689.minPartitions(n));
    }
}