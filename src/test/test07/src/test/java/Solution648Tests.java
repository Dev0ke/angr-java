import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution648Tests {
    private final Solution648 solution648 = new Solution648();

    @Test
    public void example1() {
        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";
        Assertions.assertEquals(expected, solution648.replaceWords(dictionary, sentence));
    }

    @Test
    public void example2() {
        List<String> dictionary = List.of("a", "b", "c");
        String sentence = "aadsfasf absbs bbab cadsfafs";
        String expected = "a a b c";
        Assertions.assertEquals(expected, solution648.replaceWords(dictionary, sentence));
    }

    @Test
    public void example3() {
        List<String> dictionary = List.of("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        String expected = "a a a a a a a a bbb baba a";
        Assertions.assertEquals(expected, solution648.replaceWords(dictionary, sentence));
    }

    @Test
    public void example4() {
        List<String> dictionary = List.of("catt", "cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";
        Assertions.assertEquals(expected, solution648.replaceWords(dictionary, sentence));
    }

    @Test
    public void example5() {
        List<String> dictionary = List.of("ac", "ab");
        String sentence = "it is abnormal that this solution is accepted";
        String expected = "it is ab that this solution is ac";
        Assertions.assertEquals(expected, solution648.replaceWords(dictionary, sentence));
    }
}
