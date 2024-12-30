import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution93Tests {
    private final Solution93 solution93 = new Solution93();

    @Test
    public void example1() {
        String s = "25525511135";
        List<String> expected = new ArrayList<>(List.of("255.255.11.135", "255.255.111.35"));
        List<String> actual = solution93.restoreIpAddresses(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "0000";
        List<String> expected = new ArrayList<>(List.of("0.0.0.0"));
        List<String> actual = solution93.restoreIpAddresses(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void example3() {
        String s = "1111";
        List<String> expected = new ArrayList<>(List.of("1.1.1.1"));
        List<String> actual = solution93.restoreIpAddresses(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        String s = "010010";
        List<String> expected = new ArrayList<>(List.of("0.10.0.10", "0.100.1.0"));
        List<String> actual = solution93.restoreIpAddresses(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example5() {
        String s = "101023";
        List<String> expected = new ArrayList<>(List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"));
        List<String> actual = solution93.restoreIpAddresses(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
