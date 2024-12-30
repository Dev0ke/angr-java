import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution692Tests {
    private final Solution692 solution692 = new Solution692();

    @Test
    public void example1() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> expected = List.of("i", "love");
        Assertions.assertEquals(expected, solution692.topKFrequent(words, k));
    }

    @Test
    public void example2() {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> expected = List.of("the", "is", "sunny", "day");
        Assertions.assertEquals(expected, solution692.topKFrequent(words, k));
    }
}
