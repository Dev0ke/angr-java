import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution208Tests {
    @Test
    public void example1() {
        Solution208.Trie trie = new Solution208.Trie();
        trie.insert("apple");
        // 返回 True
        Assertions.assertTrue(trie.search("apple"));
        // 返回 False
        Assertions.assertFalse(trie.search("app"));
        // 返回 True
        Assertions.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        // 返回 True
        Assertions.assertTrue(trie.search("app"));
    }
}
