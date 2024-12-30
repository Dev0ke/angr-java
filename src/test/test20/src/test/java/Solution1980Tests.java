import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1980Tests {
    private final Solution1980 solution1980 = new Solution1980();

    @Test
    public void example1() {
        String[] nums = {"01", "10"};
        List<String> expected = List.of("11", "00");
        Assertions.assertTrue(expected.contains(solution1980.findDifferentBinaryString(nums)));
    }

    @Test
    public void example2() {
        String[] nums = {"11", "10"};
        List<String> expected = List.of("11", "00");
        Assertions.assertTrue(expected.contains(solution1980.findDifferentBinaryString(nums)));
    }

    @Test
    public void example3() {
        String[] nums = {"111", "011", "001"};
        List<String> expected = List.of("101", "000", "010", "100", "110");
        Assertions.assertTrue(expected.contains(solution1980.findDifferentBinaryString(nums)));
    }
}
