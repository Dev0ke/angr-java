import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution401Tests {
    private final Solution401 solution401 = new Solution401();

    @Test
    public void example1() {
        int turnedOn = 1;
        List<String> expected = Arrays.asList("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00");
        List<String> actual = solution401.readBinaryWatch(turnedOn);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int turnedOn = 10;
        List<String> expected = Arrays.asList();
        List<String> actual = solution401.readBinaryWatch(turnedOn);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
