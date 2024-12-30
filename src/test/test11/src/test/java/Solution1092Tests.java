import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1092Tests {
    private final Solution1092 solution1092 = new Solution1092();

    @Test
    public void example1() {
        String str1 = "abac";
        String str2 = "cab";
        String expected = "cabac";
        Assertions.assertEquals(expected, solution1092.shortestCommonSupersequence(str1, str2));
    }
}
