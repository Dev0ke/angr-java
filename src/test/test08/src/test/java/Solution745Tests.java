import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution745Tests {
    @Test
    public void example1() {
        String[] words = {"apple"};
        Solution745.WordFilter wordFilter = new Solution745.WordFilter(words);

        // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suffix = "e" 。
        Assertions.assertEquals(0, wordFilter.f("a", "e"));
    }
}