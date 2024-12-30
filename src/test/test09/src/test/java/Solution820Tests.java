import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution820Tests {
    private final Solution820 solution820 = new Solution820();

    @Test
    public void example1() {
        String[] words = {"time", "me", "bell"};
        int expected = 10;
        Assertions.assertEquals(expected, solution820.minimumLengthEncoding(words));
    }

    @Test
    public void example2() {
        String[] words = {"t"};
        int expected = 2;
        Assertions.assertEquals(expected, solution820.minimumLengthEncoding(words));
    }
}
