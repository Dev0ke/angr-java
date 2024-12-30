import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2899Tests {
    private final Solution2899 solution2899 = new Solution2899();

    @Test
    public void example1() {
        List<String> words = List.of("1", "2", "prev", "prev", "prev");
        List<Integer> expected = List.of(2, 1, -1);
        Assertions.assertEquals(expected, solution2899.lastVisitedIntegers(words));
    }

    @Test
    public void example2() {
        List<String> words = List.of("1", "prev", "2", "prev", "prev");
        List<Integer> expected = List.of(1, 2, 1);
        Assertions.assertEquals(expected, solution2899.lastVisitedIntegers(words));
    }
}