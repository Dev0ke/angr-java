import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1702Tests {
    private final Solution1702 solution1702 = new Solution1702();

    @Test
    public void example1() {
        String binary = "000110";
        String expected = "111011";
        Assertions.assertEquals(expected, solution1702.maximumBinaryString(binary));
    }

    @Test
    public void example2() {
        String binary = "01";
        String expected = "01";
        Assertions.assertEquals(expected, solution1702.maximumBinaryString(binary));
    }
}