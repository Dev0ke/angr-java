import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1974Tests {
    private final Solution1974 solution1974 = new Solution1974();

    @Test
    public void example1() {
        String word = "abc";
        int expected = 5;
        Assertions.assertEquals(expected, solution1974.minTimeToType(word));
    }

    @Test
    public void example2() {
        String word = "bza";
        int expected = 7;
        Assertions.assertEquals(expected, solution1974.minTimeToType(word));
    }

    @Test
    public void example3() {
        String word = "zjpc";
        int expected = 34;
        Assertions.assertEquals(expected, solution1974.minTimeToType(word));
    }
}
