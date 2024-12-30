import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution433Tests {
    private final Solution433 solution433 = new Solution433();

    @Test
    public void example1() {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int expected = 1;
        Assertions.assertEquals(expected, solution433.minMutation(start, end, bank));
    }

    @Test
    public void example2() {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        int expected = 2;
        Assertions.assertEquals(expected, solution433.minMutation(start, end, bank));
    }

    @Test
    public void example3() {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        int expected = 3;
        Assertions.assertEquals(expected, solution433.minMutation(start, end, bank));
    }
}
