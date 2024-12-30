import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution636Tests {
    private final Solution636 solution636 = new Solution636();

    @Test
    public void example1() {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int[] expected = {3, 4};
        Assertions.assertArrayEquals(expected, solution636.exclusiveTime(n, logs));
    }

    @Test
    public void example2() {
        int n = 1;
        List<String> logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
        int[] expected = {8};
        Assertions.assertArrayEquals(expected, solution636.exclusiveTime(n, logs));
    }

    @Test
    public void example3() {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7");
        int[] expected = {7, 1};
        Assertions.assertArrayEquals(expected, solution636.exclusiveTime(n, logs));
    }
}