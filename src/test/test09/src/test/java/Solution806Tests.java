import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution806Tests {
    private final Solution806 solution806 = new Solution806();

    @Test
    public void example1() {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] expected = {3, 60};
        Assertions.assertArrayEquals(expected, solution806.numberOfLines(widths, s));
    }

    @Test
    public void example2() {
        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "bbbcccdddaaa";
        int[] expected = {2, 4};
        Assertions.assertArrayEquals(expected, solution806.numberOfLines(widths, s));
    }
}
