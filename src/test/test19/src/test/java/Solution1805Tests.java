import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1805Tests {
    private final Solution1805 solution1805 = new Solution1805();

    @Test
    public void example1() {
        String word = "a123bc34d8ef34";
        int expected = 3;
        Assertions.assertEquals(expected, solution1805.numDifferentIntegers(word));
        Assertions.assertEquals(expected, solution1805.numDifferentIntegers2(word));
    }

    @Test
    public void example2() {
        String word = "leet1234code234";
        int expected = 2;
        Assertions.assertEquals(expected, solution1805.numDifferentIntegers(word));
        Assertions.assertEquals(expected, solution1805.numDifferentIntegers2(word));
    }

    @Test
    public void example3() {
        String word = "a1b01c001";
        int expected = 1;
        Assertions.assertEquals(expected, solution1805.numDifferentIntegers(word));
        Assertions.assertEquals(expected, solution1805.numDifferentIntegers2(word));
    }
}
