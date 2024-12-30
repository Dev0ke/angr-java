import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2828Tests {
    private final Solution2828 solution2828 = new Solution2828();

    @Test
    public void example1() {
        List<String> words = List.of("alice", "bob", "charlie");
        String s = "abc";
        Assertions.assertTrue(solution2828.isAcronym(words, s));
    }

    @Test
    public void example2() {
        List<String> words = List.of("an", "apple");
        String s = "a";
        Assertions.assertFalse(solution2828.isAcronym(words, s));
    }

    @Test
    public void example3() {
        List<String> words = List.of("never", "gonna", "give", "up", "on", "you");
        String s = "ngguoy";
        Assertions.assertTrue(solution2828.isAcronym(words, s));
    }
}