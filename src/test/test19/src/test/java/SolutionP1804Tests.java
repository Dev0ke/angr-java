import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1804Tests {
    @Test
    public void example1() {
        SolutionP1804.Trie trie = new SolutionP1804.Trie();

        // 插入 "apple"。
        trie.insert("apple");

        // 插入另一个 "apple"。
        trie.insert("apple");

        // 有两个 "apple" 实例，所以返回 2。
        Assertions.assertEquals(2, trie.countWordsEqualTo("apple"));

        // "app" 是 "apple" 的前缀，所以返回 2。
        Assertions.assertEquals(2, trie.countWordsStartingWith("app"));

        // 移除一个 "apple"。
        trie.erase("apple");

        // 现在只有一个 "apple" 实例，所以返回 1。
        Assertions.assertEquals(1, trie.countWordsEqualTo("apple"));

        // 返回 1
        Assertions.assertEquals(1, trie.countWordsStartingWith("app"));

        // 移除 "apple"。现在前缀树是空的。
        trie.erase("apple");

        // 返回 0
        Assertions.assertEquals(0, trie.countWordsStartingWith("app"));
    }
}
