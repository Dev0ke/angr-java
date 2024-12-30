import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1598Tests {
    private final Solution1598 solution1598 = new Solution1598();

    @Test
    public void example1() {
        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        int expected = 2;
        Assertions.assertEquals(expected, solution1598.minOperations(logs));
    }

    @Test
    public void example2() {
        String[] logs = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        int expected = 3;
        Assertions.assertEquals(expected, solution1598.minOperations(logs));
    }

    @Test
    public void example3() {
        String[] logs = {"d1/", "../", "../", "../"};
        int expected = 0;
        Assertions.assertEquals(expected, solution1598.minOperations(logs));
    }
}
