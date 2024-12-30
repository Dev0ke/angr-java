import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1023Tests {
    private final Solution1023 solution1023 = new Solution1023();

    @Test
    public void example1() {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> expected = List.of(true, false, true, true, false);
        Assertions.assertEquals(expected, solution1023.camelMatch(queries, pattern));
    }

    @Test
    public void example2() {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBa";
        List<Boolean> expected = List.of(true, false, true, false, false);
        Assertions.assertEquals(expected, solution1023.camelMatch(queries, pattern));
    }

    @Test
    public void example3() {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBaT";
        List<Boolean> expected = List.of(false, true, false, false, false);
        Assertions.assertEquals(expected, solution1023.camelMatch(queries, pattern));
    }
}