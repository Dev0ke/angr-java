import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution557Tests {
    private final Solution557 solution557 = new Solution557();

    @Test
    public void example1() {
        String s = "Let's take LeetCode contest";
        String expected = "s'teL ekat edoCteeL tsetnoc";
        Assertions.assertEquals(expected, solution557.reverseWords(s));
    }
}
