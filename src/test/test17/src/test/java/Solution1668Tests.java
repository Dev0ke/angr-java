import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1668Tests {
    private final Solution1668 solution1668 = new Solution1668();

    @Test
    public void example1() {
        String sequence = "ababc";
        String word = "ab";
        int expected = 2;
        Assertions.assertEquals(expected, solution1668.maxRepeating(sequence, word));
    }

    @Test
    public void example2() {
        String sequence = "ababc";
        String word = "ba";
        int expected = 1;
        Assertions.assertEquals(expected, solution1668.maxRepeating(sequence, word));
    }

    @Test
    public void example3() {
        String sequence = "ababc";
        String word = "ac";
        int expected = 0;
        Assertions.assertEquals(expected, solution1668.maxRepeating(sequence, word));
    }
}
