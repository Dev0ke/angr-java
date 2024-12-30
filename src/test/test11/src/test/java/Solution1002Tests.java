import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1002Tests {
    private final Solution1002 solution1002 = new Solution1002();

    @Test
    public void example1() {
        String[] words = {"bella", "label", "roller"};
        List<String> expected = Arrays.asList("e", "l", "l");
        Assertions.assertEquals(expected, solution1002.commonChars(words));
    }

    @Test
    public void example2() {
        String[] words = {"cool", "lock", "cook"};
        List<String> expected = Arrays.asList("c", "o");
        Assertions.assertEquals(expected, solution1002.commonChars(words));
    }
}