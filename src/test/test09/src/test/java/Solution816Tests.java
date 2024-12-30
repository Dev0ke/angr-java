import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution816Tests {
    private final Solution816 solution816 = new Solution816();

    @Test
    public void example1() {
        String s = "(123)";
        List<String> expected = Arrays.asList("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)");
        List<String> actual = solution816.ambiguousCoordinates(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "(00011)";
        List<String> expected = Arrays.asList("(0.001, 1)", "(0, 0.011)");
        List<String> actual = solution816.ambiguousCoordinates(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String s = "(0123)";
        List<String> expected = Arrays.asList("(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)");
        List<String> actual = solution816.ambiguousCoordinates(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        String s = "(100)";
        List<String> expected = Arrays.asList("(10, 0)");
        List<String> actual = solution816.ambiguousCoordinates(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}