import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1239Tests {
    private final Solution1239 solution1239 = new Solution1239();

    @Test
    public void example1() {
        List<String> arr = Arrays.asList("un", "iq", "ue");
        int expected = 4;
        Assertions.assertEquals(expected, solution1239.maxLength(arr));
    }

    @Test
    public void example2() {
        List<String> arr = Arrays.asList("cha", "r", "act", "ers");
        int expected = 6;
        Assertions.assertEquals(expected, solution1239.maxLength(arr));
    }

    @Test
    public void example3() {
        List<String> arr = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
        int expected = 26;
        Assertions.assertEquals(expected, solution1239.maxLength(arr));
    }
}