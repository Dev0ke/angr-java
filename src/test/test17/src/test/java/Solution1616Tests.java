import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1616Tests {
    private final Solution1616 solution1616 = new Solution1616();

    @Test
    public void example1() {
        String a = "x";
        String b = "y";
        Assertions.assertTrue(solution1616.checkPalindromeFormation(a, b));
    }

    @Test
    public void example2() {
        String a = "abdef";
        String b = "fecab";
        Assertions.assertTrue(solution1616.checkPalindromeFormation(a, b));
    }

    @Test
    public void example3() {
        String a = "ulacfd";
        String b = "jizalu";
        Assertions.assertTrue(solution1616.checkPalindromeFormation(a, b));
    }
}