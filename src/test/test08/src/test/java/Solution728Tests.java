import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution728Tests {
    private final Solution728 solution728 = new Solution728();

    @Test
    public void example1() {
        int left = 1;
        int right = 22;
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
        Assertions.assertEquals(expected, solution728.selfDividingNumbers(left, right));
    }
}
