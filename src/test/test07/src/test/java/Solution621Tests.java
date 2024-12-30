import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution621Tests {
    private final Solution621 solution621 = new Solution621();

    @Test
    public void example1() {
        char[] tasks = UtUtils.stringToChars("""
                ["A","A","A","B","B","B"]
                """);
        int n = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solution621.leastInterval(tasks, n));
    }

    @Test
    public void example2() {
        char[] tasks = UtUtils.stringToChars("""
                ["A","A","A","B","B","B"]
                 """);
        int n = 0;
        int expected = 6;
        Assertions.assertEquals(expected, solution621.leastInterval(tasks, n));
    }

    @Test
    public void example3() {
        char[] tasks = UtUtils.stringToChars("""
                ["A","A","A","A","A","A","B","C","D","E","F","G"]
                """);
        int n = 2;
        int expected = 16;
        Assertions.assertEquals(expected, solution621.leastInterval(tasks, n));
    }
}
