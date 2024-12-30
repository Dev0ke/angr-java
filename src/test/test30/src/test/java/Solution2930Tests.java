import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2930Tests {
    private final Solution2930 solution2930 = new Solution2930();

    @Test
    public void example1() {
        int n = 4;
        int expected = 12;
        Assertions.assertEquals(expected, solution2930.stringCount(n));
        Assertions.assertEquals(expected, solution2930.stringCount2(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 83943898;
        Assertions.assertEquals(expected, solution2930.stringCount(n));
        Assertions.assertEquals(expected, solution2930.stringCount2(n));
    }
}