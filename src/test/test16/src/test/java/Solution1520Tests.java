import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1520Tests {
    private final Solution1520 solution1520 = new Solution1520();

    @Test
    public void example1() {
        String s = "adefaddaccc";
        List<String> expected = Arrays.asList("e", "f", "ccc");
        List<String> actual = solution1520.maxNumOfSubstrings(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "abbaccd";
        List<String> expected = Arrays.asList("d", "bb", "cc");
        List<String> actual = solution1520.maxNumOfSubstrings(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}