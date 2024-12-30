import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2075Tests {
    private final Solution2075 solution2075 = new Solution2075();

    @Test
    public void example1() {
        String encodedText = "ch   ie   pr";
        int rows = 3;
        String expected = "cipher";
        Assertions.assertEquals(expected, solution2075.decodeCiphertext(encodedText, rows));
    }

    @Test
    public void example2() {
        String encodedText = "iveo    eed   l te   olc";
        int rows = 4;
        String expected = "i love leetcode";
        Assertions.assertEquals(expected, solution2075.decodeCiphertext(encodedText, rows));
    }

    @Test
    public void example3() {
        String encodedText = "coding";
        int rows = 1;
        String expected = "coding";
        Assertions.assertEquals(expected, solution2075.decodeCiphertext(encodedText, rows));
    }

    @Test
    public void example4() {
        String encodedText = " b  ac";
        int rows = 2;
        String expected = " abc";
        Assertions.assertEquals(expected, solution2075.decodeCiphertext(encodedText, rows));
    }
}
