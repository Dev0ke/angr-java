import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution842Tests {
    private final Solution842 solution842 = new Solution842();

    @Test
    public void example1() {
        String num = "1101111";
        List<Integer> expected = List.of(11, 0, 11, 11);
        Assertions.assertEquals(expected, solution842.splitIntoFibonacci(num));
    }

    @Test
    public void example2() {
        String num = "112358130";
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution842.splitIntoFibonacci(num));
    }

    @Test
    public void example3() {
        String num = "0123";
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution842.splitIntoFibonacci(num));
    }
}