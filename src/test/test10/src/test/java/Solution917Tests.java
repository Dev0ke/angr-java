import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution917Tests {
    private final Solution917 solution917 = new Solution917();

    @Test
    public void example1() {
        String s = "ab-cd";
        String expected = "dc-ba";
        Assertions.assertEquals(expected, solution917.reverseOnlyLetters(s));
    }

    @Test
    public void example2() {
        String s = "a-bC-dEf-ghIj";
        String expected = "j-Ih-gfE-dCba";
        Assertions.assertEquals(expected, solution917.reverseOnlyLetters(s));
    }

    @Test
    public void example3() {
        String s = "Test1ng-Leet=code-Q!";
        String expected = "Qedo1ct-eeLg=ntse-T!";
        Assertions.assertEquals(expected, solution917.reverseOnlyLetters(s));
    }

    // 补充用例
    @Test
    public void example4() {
        String s = "7_28]";
        String expected = "7_28]";
        Assertions.assertEquals(expected, solution917.reverseOnlyLetters(s));
    }
}
