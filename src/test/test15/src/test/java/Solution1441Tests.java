import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1441Tests {
    private final Solution1441 solution1441 = new Solution1441();

    @Test
    public void example1() {
        int[] target = {1, 3};
        int n = 3;
        List<String> expected = List.of("Push", "Push", "Pop", "Push");
        Assertions.assertEquals(expected, solution1441.buildArray(target, n));
    }

    @Test
    public void example2() {
        int[] target = {1, 2, 3};
        int n = 3;
        List<String> expected = List.of("Push", "Push", "Push");
        Assertions.assertEquals(expected, solution1441.buildArray(target, n));
    }

    @Test
    public void example3() {
        int[] target = {1, 2};
        int n = 4;
        List<String> expected = List.of("Push", "Push");
        Assertions.assertEquals(expected, solution1441.buildArray(target, n));
    }
}
