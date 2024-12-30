import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1408Tests {
    private final Solution1408 solution1408 = new Solution1408();

    @Test
    public void example1() {
        String[] words = {"mass", "as", "hero", "superhero"};
        List<String> expected = List.of("as", "hero");
        Assertions.assertEquals(expected, solution1408.stringMatching(words));
    }

    @Test
    public void example2() {
        String[] words = {"leetcode", "et", "code"};
        List<String> expected = List.of("et", "code");
        Assertions.assertEquals(expected, solution1408.stringMatching(words));
    }

    @Test
    public void example3() {
        String[] words = {"blue", "green", "bu"};
        List<String> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution1408.stringMatching(words));
    }
}
