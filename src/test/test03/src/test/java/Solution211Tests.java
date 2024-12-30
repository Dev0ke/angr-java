import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution211Tests {
    @Test
    public void example1() {
        Solution211.WordDictionary wordDictionary = new Solution211.WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        // 返回 False
        Assertions.assertFalse(wordDictionary.search("pad"));
        // 返回 True
        Assertions.assertTrue(wordDictionary.search("bad"));
        // 返回 True
        Assertions.assertTrue(wordDictionary.search(".ad"));
        // 返回 True
        Assertions.assertTrue(wordDictionary.search("b.."));
    }
}
