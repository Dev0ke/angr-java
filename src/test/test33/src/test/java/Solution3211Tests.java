import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution3211Tests {
    private final Solution3211 solution3211 = new Solution3211();

    @Test
    public void example1() {
        int n = 3;
        List<String> expected = Arrays.asList("010", "011", "101", "110", "111");
        List<String> actual = solution3211.validStrings(n);
        List<String> actual2 = solution3211.validStrings2(n);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected, actual2);
    }

    @Test
    public void example2() {
        int n = 1;
        List<String> expected = Arrays.asList("0", "1");
        List<String> actual = solution3211.validStrings(n);
        List<String> actual2 = solution3211.validStrings2(n);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected, actual2);
    }
}