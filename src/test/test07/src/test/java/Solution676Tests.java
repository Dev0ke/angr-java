import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Solution676Tests {
    @Test
    public void example1() {
        Solution676.MagicDictionary magicDictionary = new Solution676.MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        // 返回 False
        Assertions.assertFalse(magicDictionary.search("hello"));
        // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        Assertions.assertTrue(magicDictionary.search("hhllo"));
        // 返回 False
        Assertions.assertFalse(magicDictionary.search("hell"));
        // 返回 False
        Assertions.assertFalse(magicDictionary.search("leetcoded"));
    }
}
