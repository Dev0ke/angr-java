import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP288Tests {
    private final SolutionP288 solutionP288 = new SolutionP288();

    @Test
    public void example1() {
        String[] dictionary = {"deer", "door", "cake", "card"};
        SolutionP288.ValidWordAbbr validWordAbbr = new SolutionP288.ValidWordAbbr(dictionary);

        // 返回 false，字典中的 "deer" 与输入 "dear" 的缩写都是 "d2r"，但这两个单词不相同
        Assertions.assertFalse(validWordAbbr.isUnique("dear"));

        // 返回 true，字典中不存在缩写为 "c2t" 的单词
        Assertions.assertTrue(validWordAbbr.isUnique("cart"));

        // 返回 false，字典中的 "cake" 与输入 "cane" 的缩写都是 "c2e"，但这两个单词不相同
        Assertions.assertFalse(validWordAbbr.isUnique("cane"));

        // 返回 true，字典中不存在缩写为 "m2e" 的单词
        Assertions.assertTrue(validWordAbbr.isUnique("make"));

        // 返回 true，因为 "cake" 已经存在于字典中，并且字典中没有其他缩写为 "c2e" 的单词
        Assertions.assertTrue(validWordAbbr.isUnique("cake"));
    }
}
